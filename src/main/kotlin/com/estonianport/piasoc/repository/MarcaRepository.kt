package com.estonianport.piasoc.repository

import com.estonianport.piasoc.model.Marca
import org.springframework.data.repository.CrudRepository

interface MarcaRepository : CrudRepository<Marca, Long>