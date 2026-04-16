package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.Nationalite;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite, Integer> {
}
