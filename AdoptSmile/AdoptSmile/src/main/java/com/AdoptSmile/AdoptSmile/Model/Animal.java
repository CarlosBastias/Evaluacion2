package com.AdoptSmile.AdoptSmile.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Animal")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_animal;

    @Column(nullable = false)
    private Integer edad;

    @Column(length = 20, nullable = false)
    private String Tamaño;

    @Column(length = 40, nullable = false)
    private String Especificaciones;

    @Column(length = 40, nullable = true)
    private String Necesidades;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_comuna", nullable = false)
    private Comuna comuna;

    @ManyToOne
    @JoinColumn(name = "id_raza", nullable = false)
    private Raza raza;

}
