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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCommande")
	private int idCommande;
	
	@Column
	private int totalprd;
	
	@Column
	private int totalqte;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> commandes=new ArrayList<LigneCommande>();

	public int getTotalprd() {
		return totalprd;
	}

	public void setTotalprd(int totalprd) {
		this.totalprd = totalprd;
	}

	public int getTotalqte() {
		return totalqte;
	}

	public void setTotalqte(int totalqte) {
		this.totalqte = totalqte;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LigneCommande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<LigneCommande> commandes) {
		this.commandes = commandes;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public Commande(int totalprd, int totalqte, User user, List<LigneCommande> commandes) {
		super();
		this.totalprd = totalprd;
		this.totalqte = totalqte;
		this.user = user;
		this.commandes = commandes;
	}

	public Commande() {
		super();
	}

	
}