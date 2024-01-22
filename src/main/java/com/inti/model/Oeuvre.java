package com.inti.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Oeuvre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String nom;
	private LocalTime duree;
	
	@ManyToMany
	@JoinTable(name = "Oeuvre_Soliste",
				joinColumns = @JoinColumn(name = "num_oeuvre"),
				inverseJoinColumns = @JoinColumn(name = "num_soliste"))
	List<Soliste> listeSolistes;
	
	public Oeuvre() {
		super();
	}
	
	public Oeuvre(int num, String nom, LocalTime duree) {
		super();
		this.num = num;
		this.nom = nom;
		this.duree = duree;
	}
	
	public Oeuvre(String nom, LocalTime duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalTime getDuree() {
		return duree;
	}

	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}
	
	

	public List<Soliste> getListeSolistes() {
		return listeSolistes;
	}

	public void setListeSolistes(List<Soliste> listeSolistes) {
		this.listeSolistes = listeSolistes;
	}

	@Override
	public String toString() {
		return "Oeuvre [num=" + num + ", nom=" + nom + ", duree=" + duree + "]";
	}

}
