package com.visa.mada.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.Visa;

@Repository
public interface VisaRepository extends JpaRepository<Visa, Integer> {
    
    public Optional<Visa> findByReference(String reference);

}
