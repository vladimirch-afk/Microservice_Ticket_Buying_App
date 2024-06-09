package ru.hse.ticketsapp.controllers

import ru.hse.ticketsapp.services.entities.OrderEntity

interface AppController {
    // Купить билет (сделать заказ)
    fun buyTicket(token : String, from: String, to: String) : Long
    // Получить информацю о заказе
    fun getOrderInfo(token: String, orderId: Long) : OrderEntity
}