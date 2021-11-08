package  com.MercureIt.GestionCandidats.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MercureIt.GestionCandidats.Entities.Candidat;
import com.MercureIt.GestionCandidats.Repositories.CandidatRepository;
import com.MercureIt.GestionCandidats.service.FilesService;
@CrossOrigin
@RestController

public class CandidatController {

	@Autowired
	private CandidatRepository candidatRepository;
	@Autowired
	private FilesService fileService;
	// get All Candidats
	
	@GetMapping("/candidats")
	public List<Candidat> getAllCandidat() {
		return candidatRepository.findAll();
	}

		@PostMapping("/File")
		public ResponseEntity<Object> file(@ModelAttribute Candidat candidat) throws Exception {
			candidat.setCvPath(candidat.getCv().getOriginalFilename());
			System.out.println(candidat.toString());
		
candidat.setCvPath(candidat.getCv().getOriginalFilename());
	//	fileService.save(candidat.getCv());
		return new ResponseEntity<Object>("jj",HttpStatus.OK);
			
			
		}
		
	
	//create Candidat  
	@PostMapping("/candidats")
	public Candidat createCandidat(@RequestBody Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	
	//delete Candidat
	@DeleteMapping("/candidat/{id}")
	public Map<String, Boolean> deleteCandidat(@PathVariable(value = "id") Long candidatId)
			throws AttributeNotFoundException {
		Candidat candidat = candidatRepository.findById(candidatId)
				.orElseThrow(() -> new AttributeNotFoundException("Candidat not found for this id :: " + candidatId));

		candidatRepository.delete(candidat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
