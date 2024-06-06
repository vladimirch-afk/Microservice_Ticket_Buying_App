package ru.hse.ticketsapp.services

interface OrderService {
    fun createOrder(token: String, from: String, to: String) : Long
    fun checkOrderStatus(token: String, orderId: Long) : String
}