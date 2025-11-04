package com.tam.prodtuits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tam.prodtuits.entities.Categorie;

@RepositoryRestResource(path = "cat")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
