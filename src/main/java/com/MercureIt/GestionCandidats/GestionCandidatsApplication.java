package com.MercureIt.GestionCandidats;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MercureIt.GestionCandidats.Entities.Poste;
import com.MercureIt.GestionCandidats.Repositories.PosteRepository;

@SpringBootApplication
public class GestionCandidatsApplication implements CommandLineRunner {

	@Autowired
	private PosteRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(GestionCandidatsApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
	       Date date = new Date();
	    
		//	repo.save(p);
		
		
	}

}
