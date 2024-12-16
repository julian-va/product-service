package port.oatput

import model.Product

interface ProductPersistencePort : GenericPersistencePort<Long, Product> {
}