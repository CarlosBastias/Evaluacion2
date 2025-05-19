package com.AdoptSmile.AdoptSmile.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = true, unique = true)
    private String correo;

    @Column(length = 25, nullable = false)
    private String contrasena;

    @Column(length = 15, nullable = false, unique = true)
    private String telefono;

    @Column(length = 80, nullable = false)
    private String direccion;

}
