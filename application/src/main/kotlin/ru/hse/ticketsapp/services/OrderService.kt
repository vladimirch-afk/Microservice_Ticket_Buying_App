package ru.hse.ticketsapp.services

import ru.hse.ticketsapp.services.entities.OrderEntity

interface OrderService {
    fun createOrder(token: String, from: String, to: String) : Long
    fun getOrder(token: String, orderId: Long) : OrderEntity
}