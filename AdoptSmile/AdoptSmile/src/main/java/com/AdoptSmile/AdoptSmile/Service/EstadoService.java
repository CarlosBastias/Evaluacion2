package com.AdoptSmile.AdoptSmile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AdoptSmile.AdoptSmile.Model.Estado;
import com.AdoptSmile.AdoptSmile.Repository.EstadoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado findById(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado update(Long id, Estado estado) {
        Estado estadoToUpdate = estadoRepository.findById(id).orElse(null);
        if (estadoToUpdate != null) {
            estadoToUpdate.setDescripcion(estado.getDescripcion());
            return estadoRepository.save(estadoToUpdate);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

    public Estado patch(Long id, Estado estado) {
        Estado estadoToPatch = estadoRepository.findById(id).orElse(null);
        if (estadoToPatch != null) {
            if (estado.getDescripcion() != null) {
                estadoToPatch.setDescripcion(estado.getDescripcion());
            }
            return estadoRepository.save(estadoToPatch);
        } else {
            return null;
        }
    }
}
