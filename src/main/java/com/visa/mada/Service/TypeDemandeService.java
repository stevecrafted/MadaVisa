package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.TypeDemande;
import com.visa.mada.Repository.TypeDemandeRepository;

@Service
public class TypeDemandeService {

    private final TypeDemandeRepository typeDemandeRepository;

    public TypeDemandeService(TypeDemandeRepository typeDemandeRepository) {
        this.typeDemandeRepository = typeDemandeRepository;
    }

    public TypeDemande create(TypeDemande typeDemande) {
        return typeDemandeRepository.save(typeDemande);
    }

    public List<TypeDemande> getAll() {
        return typeDemandeRepository.findAll();
    }

    public Optional<TypeDemande> getById(Integer id) {
        return typeDemandeRepository.findById(id);
    }

    public TypeDemande update(TypeDemande typeDemande) {
        return typeDemandeRepository.save(typeDemande);
    }

    public void delete(Integer id) {
        typeDemandeRepository.deleteById(id);
    }
}
