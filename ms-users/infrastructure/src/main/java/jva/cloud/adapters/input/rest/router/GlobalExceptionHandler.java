package jva.cloud.adapters.input.rest.router;

import jva.cloud.adapters.input.rest.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  Mono<ResponseEntity<ExceptionResponse>> handleGenericException(Exception exception) {
    return Mono.just(
        ResponseEntity.internalServerError()
            .body(
                createExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage())));
  }

  private ExceptionResponse createExceptionResponse(HttpStatus status, String error) {
    return ExceptionResponse.builder().error(error).status(status).build();
  }
}
