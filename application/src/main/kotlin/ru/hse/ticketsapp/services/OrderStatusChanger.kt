package ru.hse.ticketsapp.services

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.hse.ticketsapp.dao.OrderEntityDao
import ru.hse.ticketsapp.dao.entities.OrderEntity

@Component
class OrderStatusChanger(
    val orderEntityDao: OrderEntityDao
) {
    @Scheduled(fixedDelay = 1000)
    fun processOrderStatus() {
        orderEntityDao.findByStatus("check").get().forEach {
            val newStatus = if(Math.random() >= 0.5) "success" else "rejection"
            val curr = OrderEntity(it.id, it.userId, it.from, it.to, newStatus, it.created)
            orderEntityDao.delete(it)
            orderEntityDao.save(curr)
        }
    }
}