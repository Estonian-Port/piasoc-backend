package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.IntervaloEdad
import com.estonianport.piasoc.model.IntervaloKilometros
import com.estonianport.piasoc.model.Sexo
import com.estonianport.piasoc.model.TipoSeguro
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/datosVehiculo")
class DatosVehiculoController {

    @GetMapping("/intervaloEdad/getAll")
    fun getAllIntervaloEdad(): MutableList<IntervaloEdad> {
        return IntervaloEdad.values().toMutableList()
    }

    @GetMapping("/intervaloKilometros/getAll")
    fun getAlliIntervaloKilometros(): MutableList<IntervaloKilometros> {
        return IntervaloKilometros.values().toMutableList()
    }

    @GetMapping("/tipoSeguro/getAll")
    fun getAllTipoSeguro(): MutableList<TipoSeguro> {
        return TipoSeguro.values().toMutableList()
    }
    
}