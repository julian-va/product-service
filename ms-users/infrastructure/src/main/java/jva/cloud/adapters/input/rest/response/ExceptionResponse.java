package jva.cloud.adapters.input.rest.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ExceptionResponse {
  private HttpStatus status;
  private String error;
}
