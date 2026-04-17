package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.SituationFamiliale;
import com.visa.mada.Repository.SituationFamilialeRepository;

@Service
public class SituationFamilialeService {

    private final SituationFamilialeRepository situationFamilialeRepository;

    public SituationFamilialeService(SituationFamilialeRepository situationFamilialeRepository) {
        this.situationFamilialeRepository = situationFamilialeRepository;
    }

    public SituationFamiliale create(SituationFamiliale situationFamiliale) {
        return situationFamilialeRepository.save(situationFamiliale);
    }

    public List<SituationFamiliale> getAll() {
        return situationFamilialeRepository.findAll();
    }

    public Optional<SituationFamiliale> getById(Integer id) {
        return situationFamilialeRepository.findById(id);
    }

    public SituationFamiliale update(SituationFamiliale situationFamiliale) {
        return situationFamilialeRepository.save(situationFamiliale);
    }

    public void delete(Integer id) {
        situationFamilialeRepository.deleteById(id);
    }
}
