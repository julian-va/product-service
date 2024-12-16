package port.oatput

import model.Order

interface OrderPersistencePort : GenericPersistencePort<Long, Order> {
}