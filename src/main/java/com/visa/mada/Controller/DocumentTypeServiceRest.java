package com.visa.mada.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.mada.Model.DocumentType;
import com.visa.mada.Model.VisaType;
import com.visa.mada.Service.DocumentTypeService;
import com.visa.mada.Service.VisaTypeService;

@RestController
@RequestMapping("/api/DocumentType")
public class DocumentTypeServiceRest {

    private final DocumentTypeService documentTypeSerice;
    private final VisaTypeService visaTypeService;

    public DocumentTypeServiceRest(DocumentTypeService documentTypeSerice, VisaTypeService visaTypeService) {
        this.documentTypeSerice = documentTypeSerice;
        this.visaTypeService = visaTypeService;
    }

    @GetMapping("/{stringType}")
    public ResponseEntity<List<DocumentType>> getListDocumentType(@PathVariable String stringType) {

        Optional<VisaType> optionalVisaType = visaTypeService.getTypeVisaByLibelle(stringType);
        if (optionalVisaType.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        VisaType visaType = optionalVisaType.get();
        List<DocumentType> listDocumentType = documentTypeSerice.getAllTypesDocumentByVisaTypeId(visaType.getId());

        return ResponseEntity.ok(listDocumentType);
    }
}
