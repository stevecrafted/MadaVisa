package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Passport;
import com.visa.mada.Repository.PassportRepository;

@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport create(Passport passport) {
        return passportRepository.save(passport);
    }

    public List<Passport> getAll() {
        return passportRepository.findAll();
    }

    public Optional<Passport> getById(Integer id) {
        return passportRepository.findById(id);
    }

    public Passport update(Passport passport) {
        return passportRepository.save(passport);
    }

    public void delete(Integer id) {
        passportRepository.deleteById(id);
    }

    public Passport creerPasseport(Passport passport) {
        return create(passport);
    }

    public List<Passport> getAllPasseports() {
        return getAll();
    }

    public Optional<Passport> getPasseportById(int id) {
        return getById(id);
    }

    public void deletePasseport(int id) {
        delete(id);
    }
}
