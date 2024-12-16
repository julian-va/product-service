package jva.cloud.adapters.input.rest.router

import jakarta.validation.Valid
import jva.cloud.Utils.ConfigConstant.BASE_URL
import jva.cloud.adapters.input.rest.mapper.CategoryRestMapper
import jva.cloud.adapters.input.rest.request.CategoryCreateRequest
import jva.cloud.adapters.input.rest.request.CategoryUpdateRequest
import jva.cloud.adapters.input.rest.response.CategoryResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import port.input.CategoryServicePort

@RestController
@RequestMapping(path = [BASE_URL])
class CategoryRouterAdapter(
    private val categoryServicePort: CategoryServicePort,
    private val categoryRestMapper: CategoryRestMapper
) {
    @GetMapping()
    suspend fun retrieveAll(): ResponseEntity<Flow<CategoryResponse>> {
        val categoryFlow = categoryServicePort.findAll().firstOrNull()
        return categoryFlow?.let {
            ResponseEntity.ok()
                .body(categoryServicePort.findAll().map { category -> categoryRestMapper.toCategoryResponse(category) })
        } ?: ResponseEntity.notFound().build()
    }

    @GetMapping(path = ["/{id}"])
    suspend fun retrieveById(@PathVariable id: Long): ResponseEntity<CategoryResponse> {
        return categoryServicePort.findById(id = id)
            ?.let { category -> ResponseEntity.ok().body(categoryRestMapper.toCategoryResponse(category = category)) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping()
    suspend fun createCategory(@Valid() @RequestBody categoryCreateRequest: CategoryCreateRequest): ResponseEntity<CategoryResponse> {
        val categoryCreate =
            categoryServicePort.save(entity = categoryRestMapper.toCategory(categoryCreateRequest = categoryCreateRequest))
        return ResponseEntity(categoryRestMapper.toCategoryResponse(category = categoryCreate), HttpStatus.CREATED)
    }

    @PutMapping(path = ["/{id}"])
    suspend fun updateCategory(
        @PathVariable id: Long,
        @RequestBody categoryUpdateRequest: CategoryUpdateRequest
    ): ResponseEntity<CategoryResponse> {
        return categoryServicePort.update(
            id = id,
            entity = categoryRestMapper.toCategory(categoryUpdateRequest = categoryUpdateRequest)
        )?.let { category -> ResponseEntity.ok().body(categoryRestMapper.toCategoryResponse(category)) }
            ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping(path = ["/{id}"])
    suspend fun deleteCategory(@PathVariable id: Long): ResponseEntity<Unit> {
        categoryServicePort.delete(id = id)
        return ResponseEntity.noContent().build()
    }
}