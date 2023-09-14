package com.estonianport.piasoc.service

import GenericServiceImpl
import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.repository.ModeloRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class ModeloService : GenericServiceImpl<Modelo, Long>() {

    @Autowired
    lateinit var modeloRepository: ModeloRepository

    override val dao: CrudRepository<Modelo, Long>
        get() = modeloRepository
}