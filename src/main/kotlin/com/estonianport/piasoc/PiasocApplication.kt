package com.estonianport.piasoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PiasocApplication

fun main(args: Array<String>) {
	runApplication<PiasocApplication>(*args)
}
