package com.estonianport.piasoc.model

import jakarta.persistence.*

@Entity
data class Cotizacion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @PrimaryKeyJoinColumn
    val cliente: Cliente,

    @ManyToOne
    @PrimaryKeyJoinColumn
    val datosVehiculo: DatosVehiculo)
