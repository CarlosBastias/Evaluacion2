package com.AdoptSmile.AdoptSmile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdoptSmile.AdoptSmile.Model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
