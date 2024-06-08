package ru.hse.ticketsapp.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.hse.ticketsapp.services.OrderService
import ru.hse.ticketsapp.services.entities.OrderEntity

@RestController
class AppControllerImpl(
    val orderService: OrderService,
) : AppController {

    @PostMapping("/app/buy")
    @ResponseStatus(HttpStatus.CREATED)
    override fun buyTicket(@RequestHeader("jwt") token: String,
                           @RequestParam from: String,
                           @RequestParam to: String) : Long {
        return orderService.createOrder(token, from, to)
    }

    @GetMapping("/app/check")
    @ResponseStatus(HttpStatus.OK)
    override fun getOrderInfo(@RequestHeader("jwt") token: String,
                                  @RequestParam orderId: Long) : OrderEntity {
        val ans = orderService.getOrder(token, orderId)
        return ans
    }
}