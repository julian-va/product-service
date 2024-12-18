package jva.cloud.adapters.input.rest.response

import org.springframework.http.HttpStatus

data class ExceptionResponse(val status: HttpStatus, val error: String?)
