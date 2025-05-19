package com.AdoptSmile.AdoptSmile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdoptSmile.AdoptSmile.Model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{

    Region findByNombre(String nombre);
}
