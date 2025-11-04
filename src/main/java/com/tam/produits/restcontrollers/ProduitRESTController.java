package com.tam.prodtuits.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tam.prodtuits.entities.Produit;
import com.tam.prodtuits.service.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
	@Autowired
	ProduitService produitService;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Produit> getAllProduits() {
		return produitService.getAllProduits();
	 } 		
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	//@GetMapping("/getbyid/{id}")
	public Produit getProduitById(@PathVariable("id") Long id) {	
		return produitService.getProduitById(id);
    }
	
	@RequestMapping(value="/addprod",method = RequestMethod.POST)
	//@PostMapping("/addprod")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Produit createProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	}

	@RequestMapping(value="/updateprod",method = RequestMethod.PUT)
	//@PutMapping("/updateprod")
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}

	@RequestMapping(value="/delprod/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/delprod/{id}")
	public void deleteProduit(@PathVariable("id") Long id)
	{
		produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
	 }


}