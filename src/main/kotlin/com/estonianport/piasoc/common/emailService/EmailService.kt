package com.estonianport.piasoc.common.emailService

import com.estonianport.piasoc.errors.BusinessException
import com.estonianport.piasoc.model.Cotizacion
import jakarta.mail.MessagingException
import jakarta.mail.internet.MimeMessage
import org.apache.commons.validator.routines.EmailValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper


@Service
class EmailService {

    @Autowired
    lateinit var sender: JavaMailSender

    fun isEmailValid(target: String): Boolean {
        return target.isNotEmpty() && EmailValidator.getInstance().isValid(target)
    }

    fun sendEmail(emailBody: Email) {
        if(isEmailValid(emailBody.email)){
            sendEmailTool(emailBody.content, emailBody.email, emailBody.subject)
        }else{
            throw BusinessException("Email Invalido")
        }
    }

    private fun sendEmailTool(textMessage: String, email: String, subject: String) {
        val message: MimeMessage = sender.createMimeMessage()
        val helper = MimeMessageHelper(message)
        try {
            helper.setTo(email)
            helper.setText(textMessage, true)
            helper.setSubject(subject)
            sender.send(message)
        } catch (e: MessagingException) {
            throw BusinessException("Hubo un error al enviar el mail: ")
        }
    }

    fun enviarMailComprabanteCliente(cotizacion: Cotizacion) {
        val modelo = cotizacion.datosVehiculo.modelo
        val cliente = cotizacion.cliente

        val emailBody = Email(cotizacion.cliente.email, "Solicitud de cotizacion de seguro")


        emailBody.content = ("Buenos dias " + cliente.apellido + ", " + cliente.nombre + "<br>" +
                "Su " + modelo.tipoVehiculo.name + ": " + modelo.marca.nombre + ", " + modelo.nombre + " ha sido procesado exitosamente." + "<br>" +
                "Nuestros asesores procederan a enviarle la tasacion del seguro lo antes posible." + "<br>" + "Muchisimas gracias por utilizar nuestros servicios.")

        // Envio al cliente
        this.sendEmail(emailBody)

    }

    fun enviarMailComprabanteAseguradora(cotizacion: Cotizacion) {

        val modelo = cotizacion.datosVehiculo.modelo
        val cliente = cotizacion.cliente
        val datosVehiculo = cotizacion.datosVehiculo

        val emailBody = Email("estonianport@gmail.com", "Nueva consulta de " + cliente.apellido + ", " + cliente.nombre)

        emailBody.content = (
                "El cliente " + cliente.apellido + ", " + cliente.nombre + "<br>" +
                "Quiere realizar una consulta de cotizacion" + "<br> <br>" +
                "Vehiculo:" + "<br>" +
                modelo.tipoVehiculo.name + ", " + modelo.marca.nombre + ", " + modelo.nombre + "<br>" +
                "<br>" +
                "Datos del Vehiculo:" + "<br>" +
                "Intervalo de edad: " + datosVehiculo.intervaloEdad.name + "<br>" +
                "Intervalo de Kilometros: " + datosVehiculo.intervaloKilometros.name + "<br>" +
                "Tipo de seguro: " + datosVehiculo.tipoSeguro.name + "<br>" +
                "Tiene alarma: " + if (datosVehiculo.alarma) "Si" else "No" + "<br>" +
                "Se guarda en garage: " + if (datosVehiculo.garage) "Si" else "No" + "<br>" +
                "Es de uso particular: " + if (datosVehiculo.particular) "Si" else "No" + "<br>" +
                "Maneja el auto un menor de 25 años: " + if (datosVehiculo.hijos) "Si" else "No" + "<br>" +
                "<br>" +
                "Datos del cliente:" + "<br>" +
                "Direccion: " + cliente.ciudad + ", " + cliente.provincia + "<br>" +
                "Codigo Postal: " + cliente.codigoPostal + "<br>" +
                "Cuil: " + cliente.cuil + "<br>" +
                "Email: " + cliente.email + "<br>" +
                "Fecha de nacimiento: " + cliente.fechaNacimiento + "<br>" +
                "Sexo: " + cliente.sexo.name + "<br>" +
                "Empresa: " + if (cliente.empresa.isEmpty()) "-" else cliente.empresa + "<br>")

        // Envio a la empresa
        sendEmail(emailBody)
    }
}