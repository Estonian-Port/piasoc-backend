package com.estonianport.piasoc.dto

import com.estonianport.piasoc.model.IntervaloEdad
import com.estonianport.piasoc.model.IntervaloKilometros
import com.estonianport.piasoc.model.TipoSeguro

class DatosVehiculoDTO(

        val id: Long,

        val modelo: String,

        val anio: Int,

        val particular : Boolean,

        val alarma : Boolean,

        val garage : Boolean,

        val hijos : Boolean,

        val intervaloEdad: IntervaloEdad,

        val intervaloKilometros: IntervaloKilometros,

        val tipoSeguro: TipoSeguro)
