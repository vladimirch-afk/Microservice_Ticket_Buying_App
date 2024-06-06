package ru.hse.ticketsapp.services

import feign.FeignException
import org.springframework.stereotype.Service
import ru.hse.ticketsapp.api.AuthenticationApi
import ru.hse.ticketsapp.controllers.entities.InfoEntity

@Service
class OrderServiceImpl(
    val authenticationApi: AuthenticationApi
) : OrderService{
    override fun createOrder(token: String, from: Long, to: Long) {
    }

    override fun checkOrderStatus(token: String, orderId: Long): String {
        try {
            val info = authenticationApi.getUserInfo(token)
            val order = getOrder(info)
        } catch (e: FeignException) {
            throw IllegalArgumentException("Token is not valid or already expired.")
        }
    }

    private fun getOrder(info: InfoEntity) : Order {

    }

}