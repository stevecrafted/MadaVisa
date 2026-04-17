package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.VisaType;
import com.visa.mada.Repository.VisaTypeRepository;

@Service
public class VisaTypeService {

    private final VisaTypeRepository visaTypeRepository;

    public VisaTypeService(VisaTypeRepository visaTypeRepository) {
        this.visaTypeRepository = visaTypeRepository;
    }

    public VisaType create(VisaType visaType) {
        return visaTypeRepository.save(visaType);
    }

    public List<VisaType> getAll() {
        return visaTypeRepository.findAll();
    }

    public Optional<VisaType> getById(Integer id) {
        return visaTypeRepository.findById(id);
    }

    public VisaType update(VisaType visaType) {
        return visaTypeRepository.save(visaType);
    }

    public void delete(Integer id) {
        visaTypeRepository.deleteById(id);
    }

    public VisaType creerTypeVisa(VisaType visaType) {
        return create(visaType);
    }

    public List<VisaType> getAllTypesVisa() {
        return getAll();
    }

    public Optional<VisaType> getTypeVisaById(int id) {
        return getById(id);
    }

    public Optional<VisaType> getTypeVisaByLibelle(String name) {
        List<VisaType> matchingTypes = getAll().stream()
                .filter(type -> type.getLibelle() != null)
                .filter(type -> type.getLibelle().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        return matchingTypes.isEmpty() ? Optional.empty() : Optional.of(matchingTypes.get(0));
    }

    public void deleteTypeVisa(int id) {
        delete(id);
    }
}
