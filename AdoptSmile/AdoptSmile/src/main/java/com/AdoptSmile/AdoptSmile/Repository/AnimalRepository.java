package com.AdoptSmile.AdoptSmile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AdoptSmile.AdoptSmile.Model.Animal;
import org.springframework.stereotype.Repository;
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal findByEdad(Integer edad);
}
