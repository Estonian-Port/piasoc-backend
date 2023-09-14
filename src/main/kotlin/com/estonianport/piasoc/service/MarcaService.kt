package com.estonianport.piasoc.service

import GenericServiceImpl
import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.repository.MarcaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class MarcaService : GenericServiceImpl<Marca, Long>() {

    @Autowired
    lateinit var marcaRepository: MarcaRepository

    override val dao: CrudRepository<Marca, Long>
        get() = marcaRepository
}