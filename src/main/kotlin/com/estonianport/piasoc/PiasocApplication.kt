package com.estonianport.piasoc

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor
import org.jasypt.properties.PropertyValueEncryptionUtils.decrypt
import org.jasypt.util.text.TextEncryptor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
@EnableEncryptableProperties
class PiasocApplication

fun main(args: Array<String>) {
	runApplication<PiasocApplication>(*args)
}

class ServletInitializer : SpringBootServletInitializer() {
	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(PiasocApplication::class.java)
	}
}

@Configuration
class CorsConfig {
	@Bean
	fun corsConfigurer(): WebMvcConfigurer? {
		return object : WebMvcConfigurer {
			override fun addCorsMappings(registry: CorsRegistry) {

				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.exposedHeaders("*")
			}
		}
	}
}