package com.estonianport.piasoc.service

import GenericServiceImpl
import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.model.TipoVehiculo
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

    fun getListaMarcaByTipoVehiculo(tipoVehiculo: TipoVehiculo): MutableList<Marca>? {
        return modeloRepository.getListaMarcaByTipoVehiculo(tipoVehiculo)
    }

    fun getAllByMarcaAndTipoVehiculo(marca: Marca, tipoVehiculo: TipoVehiculo): MutableList<Modelo>? {
        return modeloRepository.getAllByMarcaAndTipoVehiculo(marca, tipoVehiculo)
    }

    fun getByNombre(modelo: String): Modelo {
        return modeloRepository.getByNombre(modelo)
    }
}