package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.VisaTransformable;
import com.visa.mada.Repository.VisaTransformableRepository;

@Service
public class VisaTransformableService {

    private final VisaTransformableRepository visaTransformableRepository;

    public VisaTransformableService(VisaTransformableRepository visaTransformableRepository) {
        this.visaTransformableRepository = visaTransformableRepository;
    }

    public VisaTransformable create(VisaTransformable visaTransformable) {
        return visaTransformableRepository.save(visaTransformable);
    }

    public List<VisaTransformable> getAll() {
        return visaTransformableRepository.findAll();
    }

    public Optional<VisaTransformable> getById(Integer id) {
        return visaTransformableRepository.findById(id);
    }

    public VisaTransformable update(VisaTransformable visaTransformable) {
        return visaTransformableRepository.save(visaTransformable);
    }

    public void delete(Integer id) {
        visaTransformableRepository.deleteById(id);
    }
}
