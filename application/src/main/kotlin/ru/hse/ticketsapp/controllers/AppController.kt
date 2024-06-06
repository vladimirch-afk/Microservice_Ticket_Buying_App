package ru.hse.ticketsapp.controllers

import org.springframework.http.ResponseEntity

interface AppController {
    fun buyTicket(token : String, from: Long, to: Long)
    fun checkOrderStatus(token: String, orderId: Long) : ResponseEntity<String>
}