package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {
}
