package com.tam.produits.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tam.produits.entities.Fichier;
import com.tam.produits.repository.FichierRepository;
import com.tam.produits.service.FichierService;
import com.tam.produits.service.ProduitService;

@Service
public class FichierServiceImpl implements FichierService {
	
	@Autowired
	FichierRepository fichierRepository;
	@Autowired
	ProduitService produitService;

	@Override
	public Fichier uplaodFichier(MultipartFile file) throws IOException {
		/*
		 * Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 * file.getContentType(), file.getBytes(), null); return
		 * imageRepository.save(image);
		 */
		return fichierRepository.save(Fichier.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Fichier getFichierDetails(Long id) throws IOException {
		
		final Optional<Fichier> dbImage = fichierRepository.findById(id);
		
		return Fichier.builder().idFichier(dbImage.get().getIdFichier())
				.name(dbImage.get().getName()).type(dbImage.get()
				.getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getFichier(Long id) throws IOException {
		final Optional<Fichier> dbImage = fichierRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteFichier(Long id) {
		fichierRepository.deleteById(id);
	}
}