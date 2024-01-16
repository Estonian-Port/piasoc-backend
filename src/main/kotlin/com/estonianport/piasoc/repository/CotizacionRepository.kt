package com.estonianport.piasoc.repository

import com.estonianport.piasoc.model.Cotizacion
import com.estonianport.piasoc.model.Marca
import org.springframework.data.repository.CrudRepository

interface CotizacionRepository : CrudRepository<Cotizacion, Long>{


}