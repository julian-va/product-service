package jva.cloud.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import port.input.CategoryServicePort
import port.oatput.CategoryPersistencePort
import service.CategoryService

@Configuration
class CreateDependence {
    @Bean
    fun bindingToCategoryServicePort(categoryPersistencePort: CategoryPersistencePort): CategoryServicePort {
        return CategoryService(categoryPersistencePort = categoryPersistencePort)
    }
}