package ru.hse.ticketsapp.services

import feign.FeignException
import org.springframework.stereotype.Service
import ru.hse.ticketsapp.api.AuthenticationApi
import ru.hse.ticketsapp.controllers.entities.InfoEntity
import ru.hse.ticketsapp.dao.OrderEntityDao
import ru.hse.ticketsapp.mapper.OrderEntityMapper
import ru.hse.ticketsapp.services.entities.OrderEntity
import java.time.LocalDateTime

@Service
class OrderServiceImpl(
    val authenticationApi: AuthenticationApi,
    val orderEntityDao: OrderEntityDao,
    val orderEntityMapper: OrderEntityMapper
) : OrderService {
    override fun createOrder(token: String, from: Long, to: Long) {
        val userId : Long
        try {
            val info = authenticationApi.getUserInfo(token)
            userId = info.id
        } catch (e: FeignException) {
            throw IllegalArgumentException("Token is not valid or already expired.")
        }
        val order = OrderEntity(
            null,
            userId,
            from,
            to,
            "check",
            LocalDateTime.now()
        )
        try {
            orderEntityDao.save(orderEntityMapper.infoServiceEntityToInfoDaoEntity(order))
        } catch (e: Exception) {
            throw IllegalArgumentException("Can not create order.")
        }
    }

    override fun checkOrderStatus(token: String, orderId: Long): String {
        val order : OrderEntity?
        try {
            val info = authenticationApi.getUserInfo(token)
            val tmp = orderEntityDao.findByOrderId(orderId) ?: throw RuntimeException("No such order.")
            order = orderEntityMapper.infoDaoEntityToInfoServiceEntity(tmp)
            if(order.userId != info.id){
                throw IllegalArgumentException("Order belongs to different user.")
            }
        } catch (e: FeignException) {
            throw IllegalArgumentException("Token is not valid or already expired.")
        }
        return order.status
    }
}