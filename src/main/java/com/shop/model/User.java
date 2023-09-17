/***********************************************************************
 * Module:  User.java
 * Author:  mic-formateur
 * Purpose: Defines the Class User
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
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String maidenName;
	
	@Column
	private String gender;
	
	@Column
	private String phone;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private Date birthdate;
	
	@Column
	private String image;
	
	@Column
	private int height;
	
	@Column
	private int weight;
	
	@Column
	private String address;
	@Column
	private boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@OneToMany(mappedBy="user")
	private List<Commande> commandes=new ArrayList<Commande>();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public int getIdUser() {
		return idUser;
	}

	public User(String firstname, String lastname, String email, String maidenName, String gender,
			String phone, String username, String password, Date birthdate, String image, int height, int weight,
			String address, List<Commande> commandes) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.maidenName = maidenName;
		this.gender = gender;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.birthdate = birthdate;
		this.image = image;
		this.height = height;
		this.weight = weight;
		this.address = address;
		this.commandes = commandes;
	}

	public User() {
		super();
	}



}