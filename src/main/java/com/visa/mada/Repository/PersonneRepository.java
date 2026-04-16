package com.visa.mada.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}