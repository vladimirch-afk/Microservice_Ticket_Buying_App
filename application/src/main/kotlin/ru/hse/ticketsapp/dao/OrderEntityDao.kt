package ru.hse.ticketsapp.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.ticketsapp.dao.entities.OrderEntity

@Repository
interface OrderEntityDao : CrudRepository<OrderEntity, Long> {
    fun findByOrderId(id: Long): OrderEntity?
}