package com.tam.produits.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fichier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFichier;
	private String name;
	private String type;
	
	@Column(name = "FICHIER", length = 4048576)
	@Lob
	private byte[] image;
	
	@OneToOne
	private Produit produit;
}