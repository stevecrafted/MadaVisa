package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.CarteResident;

@Repository
public interface CarteResidentRepository extends JpaRepository<CarteResident, Integer> {
}
