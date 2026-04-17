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

import com.visa.mada.DTO.DemandeWrapper;
import com.visa.mada.Model.Demande;
import com.visa.mada.Model.VisaType;
import com.visa.mada.Service.DemandeService;
import com.visa.mada.Service.DocumentTypeService;
import com.visa.mada.Service.VisaDocumentService;
import com.visa.mada.Service.VisaService;
import com.visa.mada.Service.VisaTypeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/demande")
public class DemandeController {

    private final VisaService visaService;
    private final DocumentTypeService documentTypeService;
    private final VisaDocumentService visaDocumentService;
    private final VisaTypeService visaTypeService;
    private final DemandeService demandeService;

    public DemandeController(VisaService visaService,
            DocumentTypeService documentTypeService, VisaDocumentService visaDocumentService,
            VisaTypeService visaTypeService, DemandeService demandeService) {
        this.visaService = visaService;
        this.documentTypeService = documentTypeService;
        this.visaDocumentService = visaDocumentService;
        this.visaTypeService = visaTypeService;
        this.demandeService = demandeService;
    }

    @GetMapping()
    public String createDemandeForm(Model model) {
        model.addAttribute("wrapper", new DemandeWrapper());
        return "visa/create";
    }

    @PostMapping()
    public String createDemande(Model model, @Valid @ModelAttribute DemandeWrapper demandeWrapper, BindingResult result,
            @RequestParam("visa_option") int visaOption,
            @RequestParam(value = "documentIds", required = false) List<Integer> documentIds,
            RedirectAttributes redirectAttributes) throws Exception {

        if (result.hasErrors()) {
            System.out.println("Veuillez corriger les champs en erreur.");
            model.addAttribute("errorMessage", "Veuillez corriger les champs en erreur.");
            model.addAttribute("wrapper", demandeWrapper);
            return "visa/create";
        }

        if (documentIds == null || documentIds.isEmpty()) {
            System.out.println("Les documents sont necessaires pour votre passeport");
            model.addAttribute("errorMessage", "Les documents sont necessaires pour votre passeport");
            model.addAttribute("wrapper", demandeWrapper);
            return "visa/create";
        }

        Optional<VisaType> visaTypeOptional = visaTypeService.getTypeVisaById(visaOption);
        if (visaTypeOptional.isEmpty()) {
            System.out.println("Type de visa introuvable");
            model.addAttribute("errorMessage", "Type de visa introuvable");
            model.addAttribute("wrapper", demandeWrapper);
            return "visa/create";
        }

        Demande demande = new Demande();

        try {
            demande = demandeService.creationDemande(demandeWrapper, documentIds, visaOption);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e);
            return "visa/create";
        }

        model.addAttribute("demande", demande);
        return "visa/list";
    }

}
