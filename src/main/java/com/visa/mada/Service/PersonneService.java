package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Personne;
import com.visa.mada.Repository.PersonneRepository;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public Personne creerPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    public Optional<Personne> getPersonneById(int id) {
        return personneRepository.findById(id);
    }

    public void deletePersonne(int id) {
        personneRepository.deleteById(id);
    }
}
