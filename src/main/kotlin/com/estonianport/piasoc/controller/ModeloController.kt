package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.model.TipoVehiculo
import com.estonianport.piasoc.service.MarcaService
import com.estonianport.piasoc.service.ModeloService
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/modelo/")
class ModeloController {

    @Autowired
    lateinit var marcaService : MarcaService

    @Autowired
    lateinit var modeloService : ModeloService

    @GetMapping("/getAll")
    fun getAll(): MutableList<Modelo> {
        return modeloService.getAll()!!
    }

    @PutMapping("/getAllByMarcaAndTipoVehiculo/{tipoVehiculo}")
    fun getAllByMarcaAndTipoVehiculo(@RequestBody marca: String, @PathVariable("tipoVehiculo") tipoVehiculo: TipoVehiculo): MutableList<Modelo> {
        return modeloService.getAllByMarcaAndTipoVehiculo(marcaService.getByNombre(marca), tipoVehiculo)!!
    }

}