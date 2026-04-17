package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.DemandeStatutHistorique;
import com.visa.mada.Model.DemandeStatutHistoriqueId;
import com.visa.mada.Repository.DemandeStatutHistoriqueRepository;

@Service
public class DemandeStatutHistoriqueService {

    private final DemandeStatutHistoriqueRepository demandeStatutHistoriqueRepository;

    public DemandeStatutHistoriqueService(DemandeStatutHistoriqueRepository demandeStatutHistoriqueRepository) {
        this.demandeStatutHistoriqueRepository = demandeStatutHistoriqueRepository;
    }

    public DemandeStatutHistorique create(DemandeStatutHistorique historique) {
        return demandeStatutHistoriqueRepository.save(historique);
    }

    public List<DemandeStatutHistorique> getAll() {
        return demandeStatutHistoriqueRepository.findAll();
    }

    public Optional<DemandeStatutHistorique> getById(DemandeStatutHistoriqueId id) {
        return demandeStatutHistoriqueRepository.findById(id);
    }

    public DemandeStatutHistorique update(DemandeStatutHistorique historique) {
        return demandeStatutHistoriqueRepository.save(historique);
    }

    public void delete(DemandeStatutHistoriqueId id) {
        demandeStatutHistoriqueRepository.deleteById(id);
    }
}
