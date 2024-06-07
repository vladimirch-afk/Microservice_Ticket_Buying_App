package ru.hse.ticketsapp.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.hse.ticketsapp.services.OrderService

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
    override fun checkOrderStatus(@RequestHeader("jwt") token: String,
                                  @RequestParam orderId: Long) : ResponseEntity<String> {
        val ans = orderService.checkOrderStatus(token, orderId)
        return ResponseEntity.status(HttpStatus.OK).body(ans)
    }
}