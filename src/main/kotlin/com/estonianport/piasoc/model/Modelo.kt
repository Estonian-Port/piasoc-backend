package com.estonianport.piasoc.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne


@Entity
data class Modelo (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val nombre: String,

    @JoinColumn(name = "tipo_vehiculo")
    val tipoVehiculo: TipoVehiculo,

    @ManyToOne
    @JoinColumn(name = "marca_id")
    val marca: Marca,

    @Column
    val anio_desde : Int,

    @Column(nullable = true)
    val anio_hasta: Int){
            
}