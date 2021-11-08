package  com.MercureIt.GestionCandidats.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MercureIt.GestionCandidats.Entities.Poste;
import com.MercureIt.GestionCandidats.Repositories.PosteRepository;
@CrossOrigin

@RestController



public class PosteController {

	@Autowired
	private com.MercureIt.GestionCandidats.Repositories.PosteRepository posteRepository;

	// get All Poste
	
	@GetMapping("/postes")
	public List<Poste> getAllPoste() {
		return posteRepository.findAll();
	}
	
	
	
	@GetMapping("/postes/{status}")
	public ResponseEntity<Object> ListePostePublié(@PathVariable("status") String status) {
	System.out.println(status);
		 return new ResponseEntity<Object>( posteRepository.findByStatus(status), HttpStatus.OK);
		
	}
		
	
	
		@PostMapping("/postes")
		public ResponseEntity<Object> ListePoste( @RequestBody Poste poste) {
		
			try
			{
				
			    Date date = new Date();
			  
			  String d = new SimpleDateFormat("yyyy-MM-dd").format(date);
			    date= new SimpleDateFormat("yyyy-MM-dd").parse(d);
			  
			    poste.setDateCreation(date);
		
				posteRepository.save((poste));
				 return new ResponseEntity<Object>(poste, HttpStatus.OK);
			}
			catch(Exception e)
			{
				 return new ResponseEntity<Object>("kkkk", HttpStatus.NOT_FOUND);
			}
	
		
		}
		
		//delete Poste
	@DeleteMapping("/poste/{id}")
	public Map<String, Boolean> deletePoste(@PathVariable(value = "id") Long posteId)
			throws AttributeNotFoundException {
		Poste poste = posteRepository.findById(posteId)
				.orElseThrow(() -> new AttributeNotFoundException("Poste not found for this id :: " + posteId));

		posteRepository.delete(poste);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
