package ru.hse.ticketsapp.services

import feign.FeignException
import org.springframework.stereotype.Service
import ru.hse.ticketsapp.api.AuthenticationApi
import ru.hse.ticketsapp.dao.OrderEntityDao
import ru.hse.ticketsapp.mapper.OrderEntityMapper
import ru.hse.ticketsapp.services.entities.OrderEntity
import java.time.LocalDateTime

@Service
class OrderServiceImpl(
    val authenticationApi: AuthenticationApi,
    val orderEntityDao: OrderEntityDao,
    val orderEntityMapper: OrderEntityMapper,
    val stationService: StationService
) : OrderService {
    override fun createOrder(token: String, from: String, to: String) : Long {
        val userId : Long
        try {
            val info = authenticationApi.getUserInfo(token)
            userId = info.id
        } catch (e: FeignException) {
            throw IllegalArgumentException("Token is not valid or already expired.")
        }
        val station1 = stationService.findStationByName(from)
        val station2 = stationService.findStationByName(to)
        val order = OrderEntity(
            null,
            userId,
            station1.id!!,
            station2.id!!,
            "check",
            LocalDateTime.now()
        )
        val orderId : Long
        try {
            orderId = orderEntityDao.save(orderEntityMapper.infoServiceEntityToInfoDaoEntity(order)).id!!
        } catch (e: Exception) {
            throw IllegalArgumentException("Can not create order.")
        }
        return orderId
    }

    override fun checkOrderStatus(token: String, orderId: Long): String {
        val order : OrderEntity?
        try {
            val info = authenticationApi.getUserInfo(token)
            val tmp = orderEntityDao.findById(orderId).get()
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