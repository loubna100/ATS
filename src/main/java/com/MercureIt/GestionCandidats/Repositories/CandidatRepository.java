package com.MercureIt.GestionCandidats.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.MercureIt.GestionCandidats.Entities.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
