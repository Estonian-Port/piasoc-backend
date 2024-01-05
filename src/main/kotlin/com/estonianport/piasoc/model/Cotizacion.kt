package com.estonianport.piasoc.model

import jakarta.persistence.*

@Entity
data class Cotizacion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(cascade= [CascadeType.PERSIST])
    @PrimaryKeyJoinColumn
    val cliente: Cliente,

    @ManyToOne(cascade=[CascadeType.PERSIST])
    @PrimaryKeyJoinColumn
    val datosVehiculo: DatosVehiculo)
