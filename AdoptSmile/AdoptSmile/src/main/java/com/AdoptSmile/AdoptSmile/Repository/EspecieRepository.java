package com.AdoptSmile.AdoptSmile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdoptSmile.AdoptSmile.Model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long>{

}
