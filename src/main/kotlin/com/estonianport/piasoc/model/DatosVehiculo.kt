package com.estonianport.piasoc.model

import jakarta.persistence.*

@Entity
data class DatosVehiculo(
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    
    @ManyToOne
    @PrimaryKeyJoinColumn
    val modelo: Modelo,
    
    @Column
    val particular : Boolean,
    
    @Column
    val alarma : Boolean,
    
    @Column
    val garage : Boolean,
    
    @Column
    val hijos : Boolean,

    @Column(name = "intervalo_edad_id")
    val intervaloEdad: IntervaloEdad,

    @Column(name = "intervalo_kilometros_id")
    val intervaloKilometros: IntervaloKilometros,

    @Column(name = "tipo_seguro_id")
    val tipoSeguro: TipoSeguro)