package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.VisaType;
import com.visa.mada.Repository.VisaTypeRepository;

@Service
public class VisaTypeService {

    private final VisaTypeRepository visaTypeRepository;

    public VisaTypeService(VisaTypeRepository visaTypeRepository) {
        this.visaTypeRepository = visaTypeRepository;
    }

    public VisaType creerTypeVisa(VisaType visaType) {
        return visaTypeRepository.save(visaType);
    }

    public List<VisaType> getAllTypesVisa() {
        return visaTypeRepository.findAll();
    }

    public Optional<VisaType> getTypeVisaById(int id) {
        return visaTypeRepository.findById(id);
    }

    public Optional<VisaType> getTypeVisaByLibelle(String name) {
        return visaTypeRepository.findByLibelle(name);
    }

    public void deleteTypeVisa(int id) {
        visaTypeRepository.deleteById(id);
    }
}
