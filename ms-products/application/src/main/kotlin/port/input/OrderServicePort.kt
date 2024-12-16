package port.input

import model.Order

interface OrderServicePort : GenericServicePort<Long, Order> {
}
