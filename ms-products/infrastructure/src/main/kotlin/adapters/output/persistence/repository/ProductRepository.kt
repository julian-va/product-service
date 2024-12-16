package jva.cloud.adapters.output.persistence.repository

import jva.cloud.adapters.output.persistence.entity.ProductEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ProductRepository : CoroutineCrudRepository<ProductEntity, Long> {
}