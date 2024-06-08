package ru.hse.ticketsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
class TicketsAppApplication

fun main(args: Array<String>) {
    runApplication<TicketsAppApplication>(*args)
}
