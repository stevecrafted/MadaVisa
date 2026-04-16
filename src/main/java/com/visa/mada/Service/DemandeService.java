package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Demande;
import com.visa.mada.Repository.DemandeRepository;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;

    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public Demande create(Demande demande) {
        return demandeRepository.save(demande);
    }

    public List<Demande> getAll() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> getById(Integer id) {
        return demandeRepository.findById(id);
    }

    public Demande update(Demande demande) {
        return demandeRepository.save(demande);
    }

    public void delete(Integer id) {
        demandeRepository.deleteById(id);
    }
}
