package ru.hse.ticketsapp.services

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.hse.ticketsapp.dao.OrderEntityDao
import ru.hse.ticketsapp.dao.entities.OrderEntity

@Component
class OrderStatusChanger(
    val orderEntityDao: OrderEntityDao
) {
    @Scheduled(fixedRate = 5000)
    fun processOrderStatus() {
        orderEntityDao.findByStatus(0).get().forEach {
            val newStatus = if(Math.random() >= 0.5) 1 else 2
            val curr = OrderEntity(it.id, it.userId, it.fromStationId, it.toStationId, newStatus, it.created)
            orderEntityDao.save(curr)
        }
    }
}