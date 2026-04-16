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

    public Personne create(Personne personne) {
        return personneRepository.save(personne);
    }

    public List<Personne> getAll() {
        return personneRepository.findAll();
    }

    public Optional<Personne> getById(Integer id) {
        return personneRepository.findById(id);
    }

    public Personne update(Personne personne) {
        return personneRepository.save(personne);
    }

    public void delete(Integer id) {
        personneRepository.deleteById(id);
    }

    public Personne creerPersonne(Personne personne) {
        return create(personne);
    }

    public List<Personne> getAllPersonnes() {
        return getAll();
    }

    public Optional<Personne> getPersonneById(int id) {
        return getById(id);
    }

    public void deletePersonne(int id) {
        delete(id);
    }
}
