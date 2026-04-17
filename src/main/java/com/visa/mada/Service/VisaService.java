package com.visa.mada.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Demandeur; 
import com.visa.mada.Model.Visa;
import com.visa.mada.Model.VisaType;
import com.visa.mada.Repository.VisaRepository;

@Service
public class VisaService {

    private final VisaRepository visaRepository;

    public VisaService(VisaRepository visaRepository) {
        this.visaRepository = visaRepository;
    }

    public Visa create(Visa visa) {
        return visaRepository.save(visa);
    }

    public List<Visa> getAll() {
        return visaRepository.findAll();
    }

    public Optional<Visa> getById(Integer id) {
        return visaRepository.findById(id);
    }

    public Visa update(Visa visa) {
        return visaRepository.save(visa);
    }

    public void delete(Integer id) {
        visaRepository.deleteById(id);
    }

    public Visa creerVisa(Demandeur personne, VisaType visaType, List<Integer> documentIds) {
        Visa visa = new Visa();
        visa.setLivraisonDate(LocalDate.now());
        visa.setExitDate(LocalDate.now().plusDays(30));
        visa.setReference(generateReference());
        // visa.setIdDemande(visaType != null ? visaType.getIdDemande() : null);
        return create(visa);
    }

    public Visa saveVisa(Visa visa) {
        return create(visa);
    }

    public List<Visa> getAllVisas() {
        return getAll();
    }

    public Optional<Visa> getVisaById(int id) {
        return getById(id);
    }

    public Optional<Visa> getVisaByReference(String reference) {
        return getAll().stream()
                .filter(visa -> visa.getReference() != null)
                .filter(visa -> visa.getReference().equalsIgnoreCase(reference))
                .findFirst();
    }

    public void deleteVisa(int id) {
        delete(id);
    }

    private String generateReference() {
        return "REF-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
