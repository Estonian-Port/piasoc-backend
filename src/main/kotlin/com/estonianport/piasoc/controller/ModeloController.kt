package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.model.TipoVehiculo
import com.estonianport.piasoc.service.ModeloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/modelo/")
@CrossOrigin("*")
class ModeloController {

    @Autowired
    lateinit var modeloService : ModeloService

    @GetMapping("/getAll")
    fun getAll(): MutableList<Modelo> {
        return modeloService.getAll()!!
    }

    @GetMapping("/getListaMarcaByTipoVehiculo")
    fun getListaMarcaByTipoVehiculo(@RequestBody tipoVehiculo: TipoVehiculo): MutableList<Marca> {
        return modeloService.getListaMarcaByTipoVehiculo(tipoVehiculo)!!
    }

    @GetMapping("/getAllByMarcaAndTipoVehiculo/{tipoVehiculo}")
    fun getAllByMarcaAndTipoVehiculo(@RequestBody marca: Marca, @PathVariable("tipoVehiculo") tipoVehiculo: TipoVehiculo): MutableList<Modelo> {
        return modeloService.getAllByMarcaAndTipoVehiculo(marca, tipoVehiculo)!!
    }

}