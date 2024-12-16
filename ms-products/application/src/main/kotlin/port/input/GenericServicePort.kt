package port.input

import kotlinx.coroutines.flow.Flow

interface GenericServicePort<I, E> {
    suspend fun findById(id: I): E?
    fun findAll(): Flow<E>
    suspend fun save(entity: E): E
    suspend fun update(id: I, entity: E): E?
    suspend fun delete(id: I): Unit
}
