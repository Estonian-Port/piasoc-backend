package com.estonianport.piasoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.estonianport.piasoc.commons.genericService.GenericServiceImpl;
import com.estonianport.piasoc.dao.DatosVehiculoDao;
import com.estonianport.piasoc.model.DatosVehiculo;
import com.estonianport.piasoc.service.DatosVehiculoService;

@Service
public class DatosVehiculoServiceImpl  extends GenericServiceImpl<DatosVehiculo, Long> implements DatosVehiculoService{

	@Autowired
	private DatosVehiculoDao datosVehiculoDao;

	@Override
	public CrudRepository<DatosVehiculo, Long> getDao() {
		return datosVehiculoDao;
	}
}
