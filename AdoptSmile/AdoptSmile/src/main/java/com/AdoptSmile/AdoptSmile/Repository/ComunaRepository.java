package com.AdoptSmile.AdoptSmile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdoptSmile.AdoptSmile.Model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long>{

    Comuna findByNombre(String nombre);
}
