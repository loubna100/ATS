package com.MercureIt.GestionCandidats.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="POSTE")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Poste {
        @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
    
        @Type(type="text")
	private String description;


	
	private float remuneration;
	private String titre;
	//private String typeContrat;
	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datePublication;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateCreation;
	
	@ManyToOne
	private Departement departement;
	@ManyToMany( fetch = FetchType.LAZY )
	private Collection <Competence> competences;

@ManyToMany( fetch = FetchType.LAZY )
	private Collection <Candidat> candidats;
	@ManyToOne
	private Equipe equipe;
	
}