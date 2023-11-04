package com.estonianport.piasoc.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Cliente(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val nombre: String,

    @Column
    val apellido: String,

    @Column(name = "sexo_id")
    val sexo: Sexo,

    @Column
    val cuil: Long,

    @Column(name = "fecha_nacimiento")
    val fechaNacimiento: LocalDate,

    @Column
    val empresa: String,

    @Column
    val ciudad: String,

    @Column
    val provincia: String,

    @Column
    val codigoPostal : Long,

    @Column
    val email: String,

    @Column
    val celular : Long,

    @Column
    val comentarios: String)