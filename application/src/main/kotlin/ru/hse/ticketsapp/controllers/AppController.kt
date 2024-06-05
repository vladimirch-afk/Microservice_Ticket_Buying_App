package ru.hse.ticketsapp.controllers

interface AppController {
    fun buyTicket(token : String, from: Long, to: Long)
    fun checkOrderStatus(token: String, orderId: Long)
}