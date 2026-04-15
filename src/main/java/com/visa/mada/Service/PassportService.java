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

    public Passport creerPasseport(Passport passport) {
        return passportRepository.save(passport);
    }

    public List<Passport> getAllPasseports() {
        return passportRepository.findAll();
    }

    public Optional<Passport> getPasseportById(int id) {
        return passportRepository.findById(id);
    }

    public void deletePasseport(int id) {
        passportRepository.deleteById(id);
    }
}
