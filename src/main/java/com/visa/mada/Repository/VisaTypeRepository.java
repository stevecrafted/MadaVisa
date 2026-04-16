package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.VisaType;

@Repository
public interface VisaTypeRepository extends JpaRepository<VisaType, Integer> {
}