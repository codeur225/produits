package com.tam.produits.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tam.produits.entities.Categorie;
import com.tam.produits.repository.CategorieRepository;
import com.tam.produits.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie saveCategorie(Categorie c) {
		return categorieRepository.save(c);
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		return categorieRepository.save(c);
	}

	@Override
	public void deleteCategorie(Categorie c) {
		categorieRepository.delete(c);
	}

	@Override
	public void deleteCategorieById(Long id) {
		categorieRepository.deleteById(id);
	}

	@Override
	public Categorie getCategorieById(Long id) {
		return categorieRepository.getReferenceById(id);
	}

	@Override
	public Categorie findCategorieById(Long id) {
		return categorieRepository.findById(id).get();
	}

	@Override
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

}
