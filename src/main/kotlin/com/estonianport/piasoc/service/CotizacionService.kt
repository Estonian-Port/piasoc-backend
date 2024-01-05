package com.estonianport.piasoc.service

import GenericServiceImpl
import com.estonianport.piasoc.model.Cotizacion
import com.estonianport.piasoc.repository.CotizacionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class CotizacionService : GenericServiceImpl<Cotizacion, Long>() {


    @Autowired
    lateinit var cotizacionRepository: CotizacionRepository

    override val dao: CrudRepository<Cotizacion, Long>
        get() = cotizacionRepository

}