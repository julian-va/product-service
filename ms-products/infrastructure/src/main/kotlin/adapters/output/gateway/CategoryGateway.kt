package jva.cloud.adapters.output.gateway

import jva.cloud.adapters.output.persistence.entity.CategoryEntity
import jva.cloud.adapters.output.persistence.mapper.CategoryMapper
import jva.cloud.adapters.output.persistence.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.Category
import org.springframework.stereotype.Component
import port.oatput.CategoryPersistencePort

@Component
class CategoryGateway(private val categoryRepository: CategoryRepository, private val categoryMapper: CategoryMapper) :
    CategoryPersistencePort {
    override suspend fun findById(id: Long): Category? {
        val categoryEntity: CategoryEntity? = categoryRepository.findById(id = id)
        if (categoryEntity != null) {
            return categoryMapper.toCategory(categoryEntity = categoryEntity)
        }
        return null
    }

    override fun findAll(): Flow<Category> {
        return categoryRepository.findAll()
            .map { categoryFlow -> categoryMapper.toCategory(categoryEntity = categoryFlow) }
    }

    override suspend fun save(entity: Category): Category {
        val categoryEntity = categoryRepository.save(entity = categoryMapper.toCategoryEntity(category = entity))
        return categoryMapper.toCategory(categoryEntity = categoryEntity)
    }

    override suspend fun update(id: Long, entity: Category): Category? {
        val categoryEntity: CategoryEntity? = categoryRepository.findById(id = id)
        return categoryEntity?.let { optionalCategoryEntity ->
            val categoryToUpdate = optionalCategoryEntity.copy(
                nameCategory = entity.validNameCategory(valueDefault = optionalCategoryEntity.nameCategory),
                description = entity.validDescription(valueDefault = optionalCategoryEntity.description),
                updateDate = entity.updateDate
            )
            return categoryMapper.toCategory(categoryEntity = categoryRepository.save(entity = categoryToUpdate))
        }
    }

    override suspend fun delete(id: Long) {
        categoryRepository.findById(id = id)?.let { categoryEntity -> categoryRepository.delete(categoryEntity) }
    }

}