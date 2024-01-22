package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author Hayri ACAR
 * 
 * Les opérations CRUD (Create, Read, Update, Delete) pour un objet Soliste.
 */

@Entity @Table
public class Soliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	
	@ManyToMany
	@JoinTable(name = "Oeuvre_Soliste",
				joinColumns = @JoinColumn(name = "num_soliste"),
				inverseJoinColumns = @JoinColumn(name = "num_oeuvre"))
	List<Oeuvre> listeOeuvres;
	
	public Soliste() {
		super();
	}
	
	public Soliste(long num, String nom, String prenom, LocalDate dateNaissance, String nationalite) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
	}
	
	public Soliste(String nom, String prenom, LocalDate dateNaissance, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	

	public List<Oeuvre> getListeOeuvres() {
		return listeOeuvres;
	}

	public void setListeOeuvres(List<Oeuvre> listeOeuvres) {
		this.listeOeuvres = listeOeuvres;
	}

	@Override
	public String toString() {
		return "Soliste [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", nationalite=" + nationalite + "]";
	}

}
