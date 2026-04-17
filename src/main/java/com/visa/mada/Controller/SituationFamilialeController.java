package com.visa.mada.Controller;

import java.util.List; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.visa.mada.Model.SituationFamiliale; 
import com.visa.mada.Service.SituationFamilialeService;

@RestController
@RequestMapping("/api/situation_familiale")
public class SituationFamilialeController {

    private final SituationFamilialeService situationFamilialeService;

    public SituationFamilialeController(SituationFamilialeService situationFamilialeService) {
        this.situationFamilialeService = situationFamilialeService;
    }

    @GetMapping
    public ResponseEntity<List<SituationFamiliale>> getListDocumentType() {
        List<SituationFamiliale> listSitutationFamiliale = situationFamilialeService.getAll();
        return ResponseEntity.ok(listSitutationFamiliale);
    }

}
