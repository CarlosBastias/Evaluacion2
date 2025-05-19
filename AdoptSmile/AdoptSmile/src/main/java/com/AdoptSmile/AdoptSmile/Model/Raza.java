package com.AdoptSmile.AdoptSmile.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Raza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_raza;

    @Column(length = 30, nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_especie", nullable = false)
    private Especie especie;

}
