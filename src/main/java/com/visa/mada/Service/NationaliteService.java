package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Nationalite;
import com.visa.mada.Repository.NationaliteRepository;

@Service
public class NationaliteService {

    private final NationaliteRepository nationaliteRepository;

    public NationaliteService(NationaliteRepository nationaliteRepository) {
        this.nationaliteRepository = nationaliteRepository;
    }

    public Nationalite create(Nationalite nationalite) {
        return nationaliteRepository.save(nationalite);
    }

    public List<Nationalite> getAll() {
        return nationaliteRepository.findAll();
    }

    public Optional<Nationalite> getById(Integer id) {
        return nationaliteRepository.findById(id);
    }

    public Nationalite update(Nationalite nationalite) {
        return nationaliteRepository.save(nationalite);
    }

    public void delete(Integer id) {
        nationaliteRepository.deleteById(id);
    }
}
