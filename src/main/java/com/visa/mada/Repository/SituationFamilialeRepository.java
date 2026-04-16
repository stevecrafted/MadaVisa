package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.SituationFamiliale;

@Repository
public interface SituationFamilialeRepository extends JpaRepository<SituationFamiliale, Integer> {
}
