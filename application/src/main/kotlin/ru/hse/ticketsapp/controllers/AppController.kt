package ru.hse.ticketsapp.controllers

import ru.hse.ticketsapp.services.entities.OrderEntity

interface AppController {
    fun buyTicket(token : String, from: String, to: String) : Long
    fun checkOrderStatus(token: String, orderId: Long) : OrderEntity
}