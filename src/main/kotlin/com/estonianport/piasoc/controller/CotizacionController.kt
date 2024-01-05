package com.estonianport.piasoc.controller

import com.estonianport.piasoc.common.emailService.EmailService
import com.estonianport.piasoc.dto.CotizacionDTO
import com.estonianport.piasoc.model.Cotizacion
import com.estonianport.piasoc.model.DatosVehiculo
import com.estonianport.piasoc.model.Modelo
import com.estonianport.piasoc.model.Sexo
import com.estonianport.piasoc.service.CotizacionService
import com.estonianport.piasoc.service.ModeloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/cotizacion")
class CotizacionController {

    @Autowired
    lateinit var emailService: EmailService

    @Autowired
    lateinit var cotizacionService: CotizacionService

    @Autowired
    lateinit var modeloService: ModeloService

    @PostMapping("/save")
    fun save(@RequestBody cotizacionDto: CotizacionDTO): String {

        val datosVehiculo = DatosVehiculo(
                0,
                modeloService.getByNombre(cotizacionDto.datosVehiculoDto.modelo),
                cotizacionDto.datosVehiculoDto.particular,
                cotizacionDto.datosVehiculoDto.alarma,
                cotizacionDto.datosVehiculoDto.garage,
                cotizacionDto.datosVehiculoDto.hijos,
                cotizacionDto.datosVehiculoDto.intervaloEdad,
                cotizacionDto.datosVehiculoDto.intervaloKilometros,
                cotizacionDto.datosVehiculoDto.tipoSeguro)


        val cotizacion = Cotizacion(0, cotizacionDto.cliente, datosVehiculo)

        cotizacionService.save(cotizacion)

        emailService.enviarMailComprabanteCliente(cotizacion);

        emailService.enviarMailComprabanteAseguradora(cotizacion);

        return "OK"
    }

}