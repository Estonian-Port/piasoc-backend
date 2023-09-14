package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.TipoVehiculo
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tipoVehiculo/")
@CrossOrigin("*")
class TipoVehiculoController {

    @GetMapping("/getAll")
    fun getAll(): MutableSet<TipoVehiculo> {
        return TipoVehiculo.values().toMutableSet()
    }
}