package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.TypeDemande;

@Repository
public interface TypeDemandeRepository extends JpaRepository<TypeDemande, Integer> {
}
