package com.MercureIt.GestionCandidats.Entities;

import java.io.File;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
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
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="CANDIDAT")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Candidat {
        @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date DateCreation;
	private String email;
	@javax.persistence.Transient
	
	private MultipartFile cv;
	private String cvPath;
    @Type(type="text")
	private String motivation;
	@ManyToOne
	private Etape etape;
	@ManyToMany
	private Collection<Competence> competences;
}
