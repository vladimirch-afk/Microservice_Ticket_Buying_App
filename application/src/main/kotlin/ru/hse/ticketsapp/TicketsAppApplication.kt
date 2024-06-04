package ru.hse.ticketsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TicketsAppApplication

fun main(args: Array<String>) {
    runApplication<TicketsAppApplication>(*args)
}
