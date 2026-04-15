package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.VisaDocument;

@Repository
public interface VisaDocumentRepository extends JpaRepository<VisaDocument, Integer> {
}