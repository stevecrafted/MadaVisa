package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Visa;
import com.visa.mada.Repository.VisaRepository;

@Service
public class VisaService {

    private final VisaRepository visaRepository;

    public VisaService(VisaRepository visaRepository) {
        this.visaRepository = visaRepository;
    }

    public Visa creerVisa(Visa visa) {
        return visaRepository.save(visa);
    }

    // Récupérer tous les visas
    public List<Visa> getAllVisas() {
        return visaRepository.findAll();
    }

    // Récupérer un visa par son ID
    public Optional<Visa> getVisaById(int id) {
        return visaRepository.findById(id);
    }

    // Récupérer par référence
    public Optional<Visa> getVisaByReference(String reference) {
        return visaRepository.findByReference(reference);
    }

    // Supprimer un visa
    public void deleteVisa(int id) {
        visaRepository.deleteById(id);
    }

}
