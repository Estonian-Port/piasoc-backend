package com.estonianport.piasoc.repository

import com.estonianport.piasoc.model.Marca
import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.model.TipoVehiculo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ModeloRepository : CrudRepository<Modelo, Long> {

    @Query(value = "SELECT m.marca FROM Modelo m WHERE m.tipoVehiculo = ?1")
    fun getListaMarcaByTipoVehiculo(tipoVehiculo: TipoVehiculo): MutableList<Marca>?

    fun getAllByMarcaAndTipoVehiculo(marca: Marca, tipoVehiculo: TipoVehiculo): MutableList<Modelo>?

    fun getByNombre(nombre: String): Modelo
}