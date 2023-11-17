package com.estonianport.piasoc.controller

import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.model.Sexo
import com.estonianport.piasoc.model.TipoVehiculo
import com.estonianport.piasoc.service.MarcaService
import com.estonianport.piasoc.service.ModeloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cliente")
class ClienteController {

    @GetMapping("/sexo/getAll")
    fun getAllSexo(): MutableList<Sexo> {
        return Sexo.values().toMutableList()
    }

}