package com.visa.mada.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.DocumentType;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
	List<DocumentType> findByVisaTypeId(int visaTypeId);
    List<DocumentType> findByIsCommunTrueAndVisaTypeId(int visaTypeId);
}