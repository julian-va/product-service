package jva.cloud.adapters.input.rest.router

import jva.cloud.adapters.input.rest.response.ExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    suspend fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<MutableMap<String, String>> {
        val mapError: MutableMap<String, String> = mutableMapOf()
        ex.bindingResult.fieldErrors.map { fieldError ->
            mapError.put("fieldName", fieldError.field)
            mapError.put("message", fieldError.defaultMessage ?: "Invalid value")
        }
        return ResponseEntity(mapError, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    suspend fun handleGenericException(ex: Exception): ResponseEntity<ExceptionResponse> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(createExceptionResponse(status = HttpStatus.INTERNAL_SERVER_ERROR, error = ex.message))
    }

    private fun createExceptionResponse(status: HttpStatus, error: String?): ExceptionResponse {
        return ExceptionResponse(status = status, error = error)
    }
}
