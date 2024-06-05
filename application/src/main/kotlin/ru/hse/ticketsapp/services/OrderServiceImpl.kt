package ru.hse.ticketsapp.services

import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService{
    override fun createOrder(token: String, from: Long, to: Long) {
        val info =
    }

    override fun checkOrderStatus(token: String, from: Long, to: Long) {
        TODO("Not yet implemented")
    }

}