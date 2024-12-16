package jva.cloud.adapters.output.persistence.mapper

import jva.cloud.adapters.output.persistence.entity.CategoryEntity
import model.Category
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CategoryMapper {
    fun toCategoryEntity(category: Category): CategoryEntity
    fun toCategory(categoryEntity: CategoryEntity): Category
    fun toListCategory(categoryEntities: List<CategoryEntity>): List<Category>
}