package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.CarteResident;
import com.visa.mada.Repository.CarteResidentRepository;

@Service
public class CarteResidentService {

    private final CarteResidentRepository carteResidentRepository;

    public CarteResidentService(CarteResidentRepository carteResidentRepository) {
        this.carteResidentRepository = carteResidentRepository;
    }

    public CarteResident create(CarteResident carteResident) {
        return carteResidentRepository.save(carteResident);
    }

    public List<CarteResident> getAll() {
        return carteResidentRepository.findAll();
    }

    public Optional<CarteResident> getById(Integer id) {
        return carteResidentRepository.findById(id);
    }

    public CarteResident update(CarteResident carteResident) {
        return carteResidentRepository.save(carteResident);
    }

    public void delete(Integer id) {
        carteResidentRepository.deleteById(id);
    }
}
