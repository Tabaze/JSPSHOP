package com.shop.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "LigneCommande")
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column
	private int qteCommandee;
	
	@Column
	private float remise;
	
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Produit commande;

	public int getQteCommandee() {
		return qteCommandee;
	}

	public void setQteCommandee(int qteCommandee) {
		this.qteCommandee = qteCommandee;
	}

	public float getRemise() {
		return remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Produit getCommande() {
		return commande;
	}

	public void setCommande(Produit commande) {
		this.commande = commande;
	}

	public int getId() {
		return Id;
	}

	public LigneCommande(int qteCommandee, float remise, Produit produit, Produit commande) {
		super();
		this.qteCommandee = qteCommandee;
		this.remise = remise;
		this.produit = produit;
		this.commande = commande;
	}

	public LigneCommande() {
		super();
	}
	
}