package com.tam.produits.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.tam.produits.entities.Fichier;
import com.tam.produits.entities.Produit;
import com.tam.produits.service.FichierService;
import com.tam.produits.service.ProduitService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/fichier")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 FichierService fichierService ;
	 
	 @Autowired
	 ProduitService produitService;
	 
	 
	 /*@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
			 file,@PathVariable("id") Long id) throws IOException {
		 Produit p = produitService.getProduitById(id);
		 p.setFichierPath(id+".jpg");

		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getFichierPath())
				 , file.getBytes());
		 produitService.saveProduit(p);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Produit p = produitService.getProduitById(id);
		 return	 Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getFichierPath()));
	 }*/	 
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Fichier uploadFichier(@RequestParam("image") MultipartFile file) throws IOException {
		 System.out.println(file);
		 	return fichierService.uplaodFichier(file);
	 }
	 
	@PostMapping(value = "/uplaodImageProd/{idProd}")
	public Fichier uploadMultiFichier(@RequestParam("image") MultipartFile file, @PathVariable("idProd") Long idProd)
			throws IOException {
		return fichierService.uplaodFichierProd(file, idProd);
	}

	@RequestMapping(value = "/getImagesProd/{idProd}", method = RequestMethod.GET)
	public List<Fichier> getImagesProd(@PathVariable("idProd") Long idProd) throws IOException {
		return fichierService.getFichierParProd(idProd);
	}
	 
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Fichier getFichierDetails(@PathVariable("id") Long id) throws IOException {
		 return fichierService.getFichierDetails(id) ;
	 }
	 
	 
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getFichier(@PathVariable("id") Long id) throws IOException{
		 return fichierService.getFichier(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteFichier(@PathVariable("id") Long id){
		 fichierService.deleteFichier(id);
	 }	 
	 
	
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Fichier UpdateFichier(@RequestParam("ichier")MultipartFile file) throws IOException {
		 return fichierService.uplaodFichier(file);
	 }
	 
}