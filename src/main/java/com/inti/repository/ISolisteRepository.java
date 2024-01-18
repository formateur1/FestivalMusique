package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Soliste;

/**
 * @author Hayri ACAR
 * 
 * Permet de réaliser les opérations avec la BDD
 */

@Repository
public interface ISolisteRepository extends JpaRepository<Soliste, Long> {

}
