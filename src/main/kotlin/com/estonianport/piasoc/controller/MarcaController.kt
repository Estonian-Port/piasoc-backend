package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.service.MarcaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/marca/")
@CrossOrigin("*")
class MarcaController {

    @Autowired
    lateinit var marcaService : MarcaService

    @GetMapping("/getAll")
    fun getAll(): MutableList<Marca> {
        return marcaService.getAll()!!
    }
}