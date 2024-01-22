package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
@Slf4j
public class Concert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String nom;
	private LocalDate dateConcert;
	
	@Exclude
	@Transient
	List<Oeuvre> listeOeuvres;
	
	

}
