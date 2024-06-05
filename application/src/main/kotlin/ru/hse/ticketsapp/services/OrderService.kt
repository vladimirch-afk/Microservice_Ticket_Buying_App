package ru.hse.ticketsapp.services

interface OrderService {
    fun createOrder(token: String, from: Long, to: Long)
    fun checkOrderStatus(token: String, from: Long, to: Long)
}