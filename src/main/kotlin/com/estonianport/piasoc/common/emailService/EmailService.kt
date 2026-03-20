package com.estonianport.piasoc.common.emailService

import com.estonianport.piasoc.errors.BusinessException
import com.estonianport.piasoc.model.Cotizacion
import org.apache.commons.validator.routines.EmailValidator
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class EmailService {

    private val httpClient = HttpClient.newHttpClient()
    private val resendApiKey = System.getenv("MAIL_PASS")
        ?: throw IllegalStateException("MAIL_PASS no definido")
    private val fromEmail = "Paula Iglesias y Asoc <paula-iglesias@estonianport.com.ar>"

    fun isEmailValid(target: String): Boolean {
        return target.isNotEmpty() && EmailValidator.getInstance().isValid(target)
    }

    fun sendEmail(emailBody: Email) {
        if (isEmailValid(emailBody.email)) {
            sendEmailTool(emailBody.content, emailBody.email, emailBody.subject)
        } else {
            throw BusinessException("Email Invalido")
        }
    }

    private fun sendEmailTool(html: String, email: String, subject: String) {
        try {
            val body = """
            {
              "from": "$fromEmail",
              "to": ["$email"],
              "subject": "$subject",
              "html": ${jsonEscape(html)}
            }
            """.trimIndent()

            val request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.resend.com/emails"))
                .header("Authorization", "Bearer $resendApiKey")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build()

            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

            if (response.statusCode() !in 200..299) {
                println("Error Resend: ${response.body()}")
                throw BusinessException("Hubo un error al enviar el mail")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            throw BusinessException("Hubo un error al enviar el mail")
        }
    }

    fun enviarMailComprabanteCliente(cotizacion: Cotizacion) {
        val modelo = cotizacion.datosVehiculo.modelo
        val cliente = cotizacion.cliente

        val content = ("Buenos dias " + cliente.apellido + ", " + cliente.nombre + "<br>" +
                "Su " + modelo.tipoVehiculo.name + ": " + modelo.marca.nombre + ", " + modelo.nombre + " ha sido procesado exitosamente." + "<br>" +
                "Nuestros asesores procederan a enviarle la tasacion del seguro lo antes posible." + "<br>" + "Muchisimas gracias por utilizar nuestros servicios.")

        // Envio al cliente
        this.sendEmail(
            Email(
                email = cotizacion.cliente.email,
                subject = "Solicitud de cotizacion de seguro",
                content = content
            )
        )
    }

    fun enviarMailComprabanteAseguradora(cotizacion: Cotizacion) {
        val modelo = cotizacion.datosVehiculo.modelo
        val cliente = cotizacion.cliente
        val datosVehiculo = cotizacion.datosVehiculo

        val content = (
                "El cliente " + cliente.apellido + ", " + cliente.nombre + "<br>" +
                        "Quiere realizar una consulta de cotizacion" + "<br> <br>" +
                        "Vehiculo:" + "<br>" +
                        modelo.tipoVehiculo.name + ", " + modelo.marca.nombre + ", " + modelo.nombre + "<br>" +
                        "<br>" +
                        "Datos del Vehiculo:" + "<br>" +
                        "Año: " + datosVehiculo.anio + "<br>" +
                        "Intervalo de edad: " + datosVehiculo.intervaloEdad.name + "<br>" +
                        "Intervalo de Kilometros: " + datosVehiculo.intervaloKilometros.name + "<br>" +
                        "Tipo de seguro: " + datosVehiculo.tipoSeguro.name + "<br>" +
                        "Tiene alarma: " + if (datosVehiculo.alarma) {"Si"} else {"No"} + "<br>" +
                        "Se guarda en garage: " + if (datosVehiculo.garage) {"Si"} else {"No"} + "<br>" +
                        "Es de uso particular: " + if (datosVehiculo.particular) {"Si"} else {"No"} + "<br>" +
                        "Maneja el auto un menor de 25 años: " + if (datosVehiculo.hijos) {"Si"} else {"No"} + "<br>" +
                        "<br>" +
                        "Datos del cliente:" + "<br>" +
                        "Telefono: " + cliente.celular + "<br>" +
                        "Direccion: " + cliente.ciudad + ", " + cliente.provincia + "<br>" +
                        "Codigo Postal: " + cliente.codigoPostal + "<br>" +
                        "Cuil: " + cliente.cuil + "<br>" +
                        "Email: " + cliente.email + "<br>" +
                        "Fecha de nacimiento: " + cliente.fechaNacimiento + "<br>" +
                        "Sexo: " + cliente.sexo.name + "<br>" +
                        "Empresa: " + if (cliente.empresa.isEmpty()) {"-"} else {cliente.empresa + "<br>"})

        // Envio a la empresa
        sendEmail(
            Email(
                email = "paulaiglesiasyasociados@gmail.com",
                subject = "Nueva consulta de " + cliente.apellido + ", " + cliente.nombre,
                content = content
            )
        )
    }

    private fun jsonEscape