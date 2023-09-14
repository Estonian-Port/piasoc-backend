package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.service.ModeloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}