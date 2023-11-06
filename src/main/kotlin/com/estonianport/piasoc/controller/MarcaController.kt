package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.model.TipoVehiculo
import com.estonianport.piasoc.service.MarcaService
import com.estonianport.piasoc.service.ModeloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/marca/")
class MarcaController {

    @Autowired
    lateinit var modeloService : ModeloService

    @Autowired
    lateinit var marcaService : MarcaService

    @GetMapping("/getAll")
    fun getAll(): MutableList<Marca> {
        return marcaService.getAll()!!
    }

    @GetMapping("/getAllByTipoVehiculo/{tipoVehiculo}")
    fun getAllByTipoVehiculo(@PathVariable("tipoVehiculo") tipoVehiculo: TipoVehiculo): MutableList<Marca> {
        return modeloService.getListaMarcaByTipoVehiculo(tipoVehiculo)!!
    }
}