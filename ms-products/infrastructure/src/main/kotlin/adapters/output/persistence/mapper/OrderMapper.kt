package jva.cloud.adapters.output.persistence.mapper

import jva.cloud.adapters.output.persistence.entity.OrderEntity
import model.Order
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface OrderMapper {
    fun toOrderEntity(order: Order): OrderEntity
    fun toOrder(orderEntity: OrderEntity): Order
    fun toListOrder(orderEntities: List<OrderEntity>): List<Order>
}