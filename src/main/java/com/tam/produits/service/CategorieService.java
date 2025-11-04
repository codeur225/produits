package com.tam.produits.service;

import java.util.List;

import com.tam.produits.entities.Categorie;


public interface CategorieService {
	Categorie saveCategorie(Categorie c);
	Categorie updateCategorie(Categorie c);
	void deleteCategorie(Categorie c);
	void deleteCategorieById(Long id);
	Categorie getCategorieById(Long id);
	Categorie findCategorieById(Long id);
	List<Categorie> getAllCategories();
}
