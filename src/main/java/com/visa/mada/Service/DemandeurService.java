package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Demandeur;
import com.visa.mada.Repository.DemandeurRepository;

@Service
public class DemandeurService {

    private final DemandeurRepository demandeurRepository;

    public DemandeurService(DemandeurRepository demandeurRepository) {
        this.demandeurRepository = demandeurRepository;
    }

    public Demandeur create(Demandeur demandeur) {
        return demandeurRepository.save(demandeur);
    }

    public List<Demandeur> getAll() {
        return demandeurRepository.findAll();
    }

    public Optional<Demandeur> getById(Integer id) {
        return demandeurRepository.findById(id);
    }

    public Demandeur update(Demandeur demandeur) {
        return demandeurRepository.save(demandeur);
    }

    public void delete(Integer id) {
        demandeurRepository.deleteById(id);
    }
}
