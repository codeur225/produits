package com.tam.produits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tam.produits.entities.Fichier;

public interface FichierRepository extends JpaRepository<Fichier , Long> {
}
