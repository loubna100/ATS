package  com.MercureIt.GestionCandidats.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MercureIt.GestionCandidats.Entities.Poste;
import java.lang.String;
import java.util.List;

public interface PosteRepository extends JpaRepository<Poste, Long> {

	
	List<Poste> findByStatus(String status);
}
