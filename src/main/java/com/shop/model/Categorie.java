/***********************************************************************
 * Module:  Categorie.java
 * Author:  mic-formateur
 * Purpose: Defines the Class Categorie
 ***********************************************************************/
package com.shop.model;

import java.util.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="Categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idCategorie;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="categorie",fetch = FetchType.EAGER)
	private List<Produit> produits=new ArrayList<Produit>();

	public Categorie(String name, List<Produit> produits) {
		super();
		this.name = name;
		this.produits = produits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public Categorie() {
		super();
	}

}