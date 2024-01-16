package com.estonianport.piasoc.dto

import com.estonianport.piasoc.model.Cliente

class CotizacionDTO(

        val id: Long,

        val cliente: Cliente,

        val datosVehiculoDto: DatosVehiculoDTO)
