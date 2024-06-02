package ru.hse.ticketsauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TicketsAuthApplication

fun main(args: Array<String>) {
    runApplication<TicketsAuthApplication>(*args)
}
