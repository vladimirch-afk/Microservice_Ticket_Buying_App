package ru.hse.ticketsapp.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.ticketsapp.dao.entities.OrderEntity
import java.util.Optional

@Repository
interface OrderEntityDao : CrudRepository<OrderEntity, Long> {
    fun findByStatus(status: Int): Optional<List<OrderEntity>>
}