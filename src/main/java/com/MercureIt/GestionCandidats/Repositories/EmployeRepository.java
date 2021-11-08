package  com.MercureIt.GestionCandidats.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MercureIt.GestionCandidats.Entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
