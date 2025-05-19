package com.AdoptSmile.AdoptSmile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdoptSmile.AdoptSmile.Model.Animal;
import com.AdoptSmile.AdoptSmile.Repository.AnimalRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal update(Long id, Animal animal) {
        Animal animalToUpdate = animalRepository.findById(id).orElse(null);
        if (animalToUpdate != null) {
            animalToUpdate.setEdad(animal.getEdad());
            animalToUpdate.setEspecificaciones(animal.getEspecificaciones());
            animalToUpdate.setNecesidades(animal.getNecesidades());
            animalToUpdate.setTamaño(animal.getTamaño());
            return animalRepository.save(animalToUpdate);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal patch(Long id, Animal animal) {
        Animal animalToPatch = animalRepository.findById(id).orElse(null);
        if (animalToPatch != null) {
            if (animal.getEdad() != null){ 
                animalToPatch.setEdad(animal.getEdad());
            }
            if (animal.getEspecificaciones() != null){
                animalToPatch.setEspecificaciones(animal.getEspecificaciones());
            }
            if (animal.getNecesidades() != null){
                animalToPatch.setNecesidades(animal.getNecesidades());
            }
            if (animal.getTamaño() != null){
                animalToPatch.setTamaño(animal.getTamaño());
            }
            return animalRepository.save(animalToPatch);
        } else {
            return null;
        }
    }

    public Animal buscarPorEdad(Integer edad) {
        return animalRepository.findByEdad(edad);
    }
}
