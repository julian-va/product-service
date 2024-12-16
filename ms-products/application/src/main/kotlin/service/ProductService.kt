package service

import kotlinx.coroutines.flow.Flow
import model.Product
import port.input.ProductServicePort
import port.oatput.ProductPersistencePort

class ProductService(private val productPersistencePort: ProductPersistencePort) : ProductServicePort {
    override suspend fun findById(id: Long): Product? {
        return productPersistencePort.findById(id = id)
    }

    override fun findAll(): Flow<Product> {
        return productPersistencePort.findAll()
    }

    override suspend fun save(entity: Product): Product {
        return productPersistencePort.save(entity = entity)
    }

    override suspend fun update(id: Long, entity: Product): Product? {
        return productPersistencePort.update(id = id, entity = entity)
    }

    override suspend fun delete(id: Long) {
        return productPersistencePort.delete(id = id)
    }
}