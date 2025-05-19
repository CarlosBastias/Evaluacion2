package com.AdoptSmile.AdoptSmile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdoptSmile.AdoptSmile.Model.Especie;
import com.AdoptSmile.AdoptSmile.Repository.EspecieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    public Especie findById(Long id) {
        return especieRepository.findById(id).orElse(null);
    }

    public List<Especie> findAll() {
        return especieRepository.findAll();
    }

    public Especie save(Especie especie) {
        return especieRepository.save(especie);
    }

    public Especie update(Long id, Especie especie) {
        Especie especieToUpdate = especieRepository.findById(id).orElse(null);
        if (especieToUpdate != null) {
            especieToUpdate.setNombre(especie.getNombre());
            return especieRepository.save(especieToUpdate);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        especieRepository.deleteById(id);
    }

    public Especie patch(Long id, Especie especie) {
        Especie especieToPatch = especieRepository.findById(id).orElse(null);
        if (especieToPatch != null) {
            if (especie.getNombre() != null) {
                especieToPatch.setNombre(especie.getNombre());
            }
            return especieRepository.save(especieToPatch);
        } else {
            return null;
        }
    }
}
