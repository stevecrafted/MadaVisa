package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.StatutDemande;
import com.visa.mada.Repository.StatutDemandeRepository;

@Service
public class StatutDemandeService {

    private final StatutDemandeRepository statutDemandeRepository;

    public StatutDemandeService(StatutDemandeRepository statutDemandeRepository) {
        this.statutDemandeRepository = statutDemandeRepository;
    }

    public StatutDemande create(StatutDemande statutDemande) {
        return statutDemandeRepository.save(statutDemande);
    }

    public List<StatutDemande> getAll() {
        return statutDemandeRepository.findAll();
    }

    public Optional<StatutDemande> getById(Integer id) {
        return statutDemandeRepository.findById(id);
    }

    public StatutDemande update(StatutDemande statutDemande) {
        return statutDemandeRepository.save(statutDemande);
    }

    public void delete(Integer id) {
        statutDemandeRepository.deleteById(id);
    }
}
