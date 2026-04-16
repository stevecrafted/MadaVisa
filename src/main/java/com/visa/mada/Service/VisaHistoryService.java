package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.VisaHistory;
import com.visa.mada.Model.VisaHistoryId;
import com.visa.mada.Repository.VisaHistoryRepository;

@Service
public class VisaHistoryService {

    private final VisaHistoryRepository visaHistoryRepository;

    public VisaHistoryService(VisaHistoryRepository visaHistoryRepository) {
        this.visaHistoryRepository = visaHistoryRepository;
    }

    public VisaHistory create(VisaHistory visaHistory) {
        return visaHistoryRepository.save(visaHistory);
    }

    public List<VisaHistory> getAll() {
        return visaHistoryRepository.findAll();
    }

    public Optional<VisaHistory> getById(VisaHistoryId id) {
        return visaHistoryRepository.findById(id);
    }

    public VisaHistory update(VisaHistory visaHistory) {
        return visaHistoryRepository.save(visaHistory);
    }

    public void delete(VisaHistoryId id) {
        visaHistoryRepository.deleteById(id);
    }

    public VisaHistory creerHistoriqueVisa(VisaHistory visaHistory) {
        return create(visaHistory);
    }

    public List<VisaHistory> getAllHistoriquesVisa() {
        return getAll();
    }

    public Optional<VisaHistory> getHistoriqueVisaById(Integer idDemande, Integer idStatutDemande) {
        return getById(new VisaHistoryId(idDemande, idStatutDemande));
    }

    public void deleteHistoriqueVisa(Integer idDemande, Integer idStatutDemande) {
        delete(new VisaHistoryId(idDemande, idStatutDemande));
    }
}
