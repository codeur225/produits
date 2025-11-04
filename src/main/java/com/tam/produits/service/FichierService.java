package com.tam.produits.service;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.tam.produits.entities.Fichier;

public interface FichierService {
	Fichier uplaodFichier(MultipartFile file) throws IOException;

	Fichier getFichierDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getFichier(Long id) throws IOException;

	void deleteFichier(Long id);
}
