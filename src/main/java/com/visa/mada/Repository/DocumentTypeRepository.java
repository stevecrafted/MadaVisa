package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.DocumentType;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
}