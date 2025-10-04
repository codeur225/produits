package com.tam.prodtuits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tam.prodtuits.entities.Categorie;
import com.tam.prodtuits.service.CategorieService;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {
	
	@Autowired
	CategorieService categorieService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categorie> getAllCategories(){
		return categorieService.getAllCategories();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
		return categorieService.findCategorieById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieService.saveCategorie(categorie);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		return categorieService.updateCategorie(categorie);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCategorie(@PathVariable("id") Long id){
		categorieService.deleteCategorieById(id);
	}

}
