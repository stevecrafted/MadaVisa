package com.visa.mada.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.DocumentType;
import com.visa.mada.Model.VisaType;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
    List<DocumentType> findByEstObligatoireTrueAndVisaTypeIdVisaType(int idVisaType);
    List<DocumentType> findByVisaType(VisaType visaType);
    List<DocumentType> findByVisaTypeIdVisaType(int idVisaType);
}