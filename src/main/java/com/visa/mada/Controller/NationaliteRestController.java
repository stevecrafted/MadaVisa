package com.visa.mada.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.mada.Model.Nationalite;
import com.visa.mada.Model.VisaType;
import com.visa.mada.Service.NationaliteService;
import com.visa.mada.Service.VisaTypeService;

@RestController
@RequestMapping("/api/nationalite")
public class NationaliteRestController {

    private final NationaliteService NationaliteSerice;
    private final VisaTypeService visaTypeService;

    public NationaliteRestController(NationaliteService NationaliteSerice, VisaTypeService visaTypeService) {
        this.NationaliteSerice = NationaliteSerice;
        this.visaTypeService = visaTypeService;
    }

    @GetMapping()
    public ResponseEntity<List<Nationalite>> getListNationalite() {
        List<Nationalite> listNationalite = NationaliteSerice.getAll();
        return ResponseEntity.ok(listNationalite);
    }
}
