package jva.cloud.adapters.output.persistence.repository

import jva.cloud.adapters.output.persistence.entity.CategoryEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CategoryRepository : CoroutineCrudRepository<CategoryEntity, Long> {
}