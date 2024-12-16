package service

import kotlinx.coroutines.flow.Flow
import model.Order
import port.input.OrderServicePort
import port.oatput.OrderPersistencePort

class OrderService(private val orderPersistencePort: OrderPersistencePort) : OrderServicePort {
    override suspend fun findById(id: Long): Order? {
        return orderPersistencePort.findById(id = id)
    }

    override fun findAll(): Flow<Order> {
        return orderPersistencePort.findAll()
    }

    override suspend fun save(entity: Order): Order {
        return orderPersistencePort.save(entity = entity)
    }

    override suspend fun update(id: Long, entity: Order): Order? {
        return orderPersistencePort.update(id = id, entity = entity)
    }

    override suspend fun delete(id: Long) {
        return orderPersistencePort.delete(id = id)
    }
}