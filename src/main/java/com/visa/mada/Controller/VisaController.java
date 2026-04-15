package com.visa.mada.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.mada.Model.Personne;
import com.visa.mada.Model.Visa;
import com.visa.mada.Service.PersonneService;
import com.visa.mada.Service.VisaService;

@Controller
@RequestMapping("/visa")
public class VisaController {

    private final VisaService visaService;
    private final PersonneService personneService;

    public VisaController(VisaService visaService, PersonneService personneService) {
        this.visaService = visaService;
        this.personneService = personneService;
    }

    @GetMapping()
    public String createVisaForm(Model model) { 
        return "visa/create";
    }

    @PostMapping()
    public String createVisa(Model model, @ModelAttribute Personne personne) {
        personneService.creerPersonne(personne);
        return "visa/list";
    }
    
}
