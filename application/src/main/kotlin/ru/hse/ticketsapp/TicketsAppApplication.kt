package ru.hse.ticketsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.c

@SpringBootApplication
@EnableFeignClients
class TicketsAppApplication

fun main(args: Array<String>) {
    runApplication<TicketsAppApplication>(*args)
}
