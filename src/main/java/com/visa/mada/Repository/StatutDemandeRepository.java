package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.StatutDemande;

@Repository
public interface StatutDemandeRepository extends JpaRepository<StatutDemande, Integer> {
}
