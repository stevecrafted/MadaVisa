package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.Demandeur;

@Repository
public interface DemandeurRepository extends JpaRepository<Demandeur, Integer> {
}
