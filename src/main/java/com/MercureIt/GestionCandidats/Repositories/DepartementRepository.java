package  com.MercureIt.GestionCandidats.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MercureIt.GestionCandidats.Entities.Departement;

@Repository
public interface DepartementRepository   extends JpaRepository<Departement, Long>{

}
