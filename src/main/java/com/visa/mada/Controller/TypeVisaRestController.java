package com.visa.mada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.mada.Model.VisaType;
import com.visa.mada.Service.VisaTypeService;

import java.util.List; 

@RestController
@RequestMapping("/api/typevisa")
public class TypeVisaRestController {
    
    private final VisaTypeService visaTypeService;

    public TypeVisaRestController(VisaTypeService visaTypeService) {
        this.visaTypeService = visaTypeService;
    }

    @GetMapping()
    public ResponseEntity<List<VisaType>> getListVisaType() {
        return ResponseEntity.ok(visaTypeService.getAllTypesVisa());
    }
}
