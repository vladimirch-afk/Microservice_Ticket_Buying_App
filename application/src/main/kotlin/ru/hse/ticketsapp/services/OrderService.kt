package ru.hse.ticketsapp.services

import ru.hse.ticketsapp.services.entities.OrderEntity

interface OrderService {
    // Создать заказ
    fun createOrder(token: String, from: String, to: String) : Long
    // Получить информацию о заказе
    fun getOrder(token: String, orderId: Long) : OrderEntity
}