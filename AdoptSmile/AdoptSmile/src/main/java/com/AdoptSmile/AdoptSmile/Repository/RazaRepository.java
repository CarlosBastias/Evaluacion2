package com.AdoptSmile.AdoptSmile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdoptSmile.AdoptSmile.Model.Raza;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Long>{

    Raza findByTipo(String tipo);
}
