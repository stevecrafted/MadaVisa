package com.visa.mada.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.visa.mada.Model.Personne;
import com.visa.mada.Model.VisaType;
import com.visa.mada.Service.DocumentTypeService;
import com.visa.mada.Service.PersonneService;
import com.visa.mada.Service.VisaDocumentService;
import com.visa.mada.Service.VisaService;
import com.visa.mada.Service.VisaTypeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/visa")
public class VisaController {

    private final VisaService visaService;
    private final PersonneService personneService;
    private final DocumentTypeService documentTypeService;
    private final VisaDocumentService visaDocumentService;
    private final VisaTypeService visaTypeService;

    public VisaController(VisaService visaService, PersonneService personneService,
            DocumentTypeService documentTypeService, VisaDocumentService visaDocumentService,
            VisaTypeService visaTypeService) {
        this.visaService = visaService;
        this.personneService = personneService;
        this.documentTypeService = documentTypeService;
        this.visaDocumentService = visaDocumentService;
        this.visaTypeService = visaTypeService;
    }

    @GetMapping()
    public String createVisaForm(Model model) {
        model.addAttribute("personne", new Personne());
        return "visa/create";
    }

    @PostMapping()
    public String createVisa(Model model, @Valid @ModelAttribute Personne personne, BindingResult result,
            @RequestParam("visa_option") int visaOption,
            @RequestParam(value = "documentIds", required = false) List<Integer> documentIds,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            System.out.println("Veuillez corriger les champs en erreur.");
            model.addAttribute("errorMessage", "Veuillez corriger les champs en erreur.");
            return "visa/create";
        }

        if (documentIds == null || documentIds.isEmpty()) {
            System.out.println("Les documents sont necessaires pour votre passeport");
            model.addAttribute("errorMessage", "Les documents sont necessaires pour votre passeport");
            return "visa/create";
        }

        Optional<VisaType> visaTypeOptional = visaTypeService.getTypeVisaById(visaOption);
        if (visaTypeOptional.isEmpty()) {
            System.out.println("Type de visa introuvable");
            model.addAttribute("errorMessage", "Type de visa introuvable");
            return "visa/create";
        }

        visaService.creerVisa(personne, visaTypeOptional.get(), documentIds);

        return "visa/list";
    }

}
