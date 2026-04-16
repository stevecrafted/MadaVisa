package com.visa.mada.Controller;

import java.util.List;
import java.util.Optional;
import com.visa.mada.Model.DocumentType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.visa.mada.Model.Personne;
import com.visa.mada.Service.DocumentTypeService;
import com.visa.mada.Service.PersonneService;
import com.visa.mada.Service.VisaService;

@Controller
@RequestMapping("/visa")
public class VisaController {

    private final VisaService visaService;
    private final PersonneService personneService;
    private final DocumentTypeService documentTypeService;

    public VisaController(VisaService visaService, PersonneService personneService, DocumentTypeService documentTypeService) {
        this.visaService = visaService;
        this.personneService = personneService;
        this.documentTypeService = documentTypeService;
    }

    @GetMapping()
    public String createVisaForm(Model model) { 
        model.addAttribute("personne", new Personne()); 
        return "visa/create";
    }

    @PostMapping()
    public String createVisa(Model model, @ModelAttribute Personne personne, RedirectAttributes redirectAttributes) {
        personneService.creerPersonne(personne);
        redirectAttributes.addFlashAttribute("errorMessage", "Veuillez selectionnez le type de transformation de votre visa");
        return "visa/list";
    }

}
