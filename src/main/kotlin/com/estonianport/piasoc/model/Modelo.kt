package com.estonianport.piasoc.model

import jakarta.persistence.*


@Entity
data class Modelo (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val nombre: String,

    @Column(name = "tipo_vehiculo_id")
    val tipoVehiculo: TipoVehiculo,

    @ManyToOne
    @PrimaryKeyJoinColumn
    val marca: Marca,

    @Column
    val anio_desde : Int){


    @Column
    val anio_hasta: Int? = null
            
}