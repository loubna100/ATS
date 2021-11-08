package com.MercureIt.GestionCandidats.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MercureIt.GestionCandidats.Entities.Equipe;
import com.MercureIt.GestionCandidats.Repositories.EquipeRepository;

@CrossOrigin

@RestController

public class EquipeController {

	@Autowired
	private EquipeRepository equipeRepository;

	// get All Equipes
	
	@GetMapping("/equipes")
	public List<Equipe> getAllEquipe() {
		return equipeRepository.findAll();
	}
	
	//create Equipe  
	@PostMapping("/equipes")
	public Equipe createEquipe(@RequestBody Equipe equipe) {
		return equipeRepository.save(equipe);
	}
	
	//delete Equipe
	@DeleteMapping("/equipe/{id}")
	public Map<String, Boolean> deleteEquipe(@PathVariable(value = "id") Long equipeId)
			throws AttributeNotFoundException {
		Equipe equipe = equipeRepository.findById(equipeId)
				.orElseThrow(() -> new AttributeNotFoundException("Equipe not found for this id :: " + equipeId));

		equipeRepository.delete(equipe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
