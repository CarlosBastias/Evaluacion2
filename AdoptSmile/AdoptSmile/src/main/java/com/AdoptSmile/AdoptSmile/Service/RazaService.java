package com.AdoptSmile.AdoptSmile.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AdoptSmile.AdoptSmile.Model.Raza;
import com.AdoptSmile.AdoptSmile.Repository.RazaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RazaService {

    @Autowired
    private RazaRepository razaRepository;

    public Raza findById(Long id) {
        return razaRepository.findById(id).orElse(null);
    }

    public List<Raza> findAll() {
        return razaRepository.findAll();
    }

    public Raza save(Raza raza) {
        return razaRepository.save(raza);
    }

    public Raza update(Long id, Raza raza) {
        Raza razaToUpdate = razaRepository.findById(id).orElse(null);
        if (razaToUpdate != null) {
            razaToUpdate.setTipo(raza.getTipo());
            return razaRepository.save(razaToUpdate);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        razaRepository.deleteById(id);
    }

    public Raza patch(Long id, Raza raza) {
        Raza razaToPatch = razaRepository.findById(id).orElse(null);
        if (razaToPatch != null) {
            if (raza.getTipo() != null) {
                razaToPatch.setTipo(raza.getTipo());
            }
            return razaRepository.save(razaToPatch);
        } else {
            return null;
        }
    }

    public Raza buscarPorTipo(String tipo) {
        return razaRepository.findByTipo(tipo);
    }
}
