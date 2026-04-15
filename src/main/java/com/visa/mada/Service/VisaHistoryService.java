package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.VisaHistory;
import com.visa.mada.Repository.VisaHistoryRepository;

@Service
public class VisaHistoryService {

    private final VisaHistoryRepository visaHistoryRepository;

    public VisaHistoryService(VisaHistoryRepository visaHistoryRepository) {
        this.visaHistoryRepository = visaHistoryRepository;
    }

    public VisaHistory creerHistoriqueVisa(VisaHistory visaHistory) {
        return visaHistoryRepository.save(visaHistory);
    }

    public List<VisaHistory> getAllHistoriquesVisa() {
        return visaHistoryRepository.findAll();
    }

    public Optional<VisaHistory> getHistoriqueVisaById(int id) {
        return visaHistoryRepository.findById(id);
    }

    public void deleteHistoriqueVisa(int id) {
        visaHistoryRepository.deleteById(id);
    }
}
