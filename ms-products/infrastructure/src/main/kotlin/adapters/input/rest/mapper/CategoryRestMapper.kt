package jva.cloud.adapters.input.rest.mapper

import jva.cloud.adapters.input.rest.request.CategoryCreateRequest
import jva.cloud.adapters.input.rest.request.CategoryUpdateRequest
import jva.cloud.adapters.input.rest.response.CategoryResponse
import model.Category
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CategoryRestMapper {
    fun toCategoryResponse(category: Category): CategoryResponse
    fun toCategory(categoryCreateRequest: CategoryCreateRequest): Category
    fun toCategory(categoryUpdateRequest: CategoryUpdateRequest): Category
}