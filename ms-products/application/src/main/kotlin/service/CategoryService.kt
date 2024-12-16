package service

import kotlinx.coroutines.flow.Flow
import model.Category
import port.input.CategoryServicePort
import port.oatput.CategoryPersistencePort

class CategoryService(private val categoryPersistencePort: CategoryPersistencePort) : CategoryServicePort {
    override suspend fun findById(id: Long): Category? {
        return categoryPersistencePort.findById(id = id)
    }

    override fun findAll(): Flow<Category> {
        return categoryPersistencePort.findAll()
    }

    override suspend fun save(entity: Category): Category {
        return categoryPersistencePort.save(entity = entity)
    }

    override suspend fun update(id: Long, entity: Category): Category? {
        return categoryPersistencePort.update(id = id, entity = entity)
    }

    override suspend fun delete(id: Long) {
        return categoryPersistencePort.delete(id = id)
    }
}