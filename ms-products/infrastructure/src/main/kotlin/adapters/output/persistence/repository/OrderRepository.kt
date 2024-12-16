package jva.cloud.adapters.output.persistence.repository

import jva.cloud.adapters.output.persistence.entity.OrderEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderRepository : CoroutineCrudRepository<OrderEntity, Long> {
}