package com.AdoptSmile.AdoptSmile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdoptSmile.AdoptSmile.Model.Comuna;
import com.AdoptSmile.AdoptSmile.Repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public Comuna findById(Long id) {
        return comunaRepository.findById(id).orElse(null);
    }

    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    public Comuna save(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public Comuna update(Long id, Comuna comuna) {
        Comuna comunaToUpdate = comunaRepository.findById(id).orElse(null);
        if (comunaToUpdate != null) {
            comunaToUpdate.setNombre(comuna.getNombre());
            return comunaRepository.save(comunaToUpdate);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        comunaRepository.deleteById(id);
    }

    public Comuna patch(Long id, Comuna comuna) {
        Comuna comunaToPatch = comunaRepository.findById(id).orElse(null);
        if (comunaToPatch != null) {
            if (comuna.getNombre() != null) {
                comunaToPatch.setNombre(comuna.getNombre());
            }
            return comunaRepository.save(comunaToPatch);
        } else {
            return null;
        }
    }

    public Comuna buscarPorNombre(String nombre) {
        return comunaRepository.findByNombre(nombre);
    }
}
