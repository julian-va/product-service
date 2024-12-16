package jva.cloud.adapters.input.rest.router;

import static jva.cloud.utils.ConfigConstant.BASE_URL;

import jakarta.validation.Valid;
import java.util.List;
import jva.cloud.adapters.input.rest.mapper.UserCreateMapper;
import jva.cloud.adapters.input.rest.mapper.UserResponseMapper;
import jva.cloud.adapters.input.rest.mapper.UserUpdateMapper;
import jva.cloud.adapters.input.rest.request.UserCreate;
import jva.cloud.adapters.input.rest.request.UserUpdate;
import jva.cloud.adapters.input.rest.response.UserResponse;
import jva.cloud.ports.input.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(path = BASE_URL)
@RequiredArgsConstructor
public class UserRouterAdapter {
  private final UserResponseMapper userResponseMapper;
  private final UserCreateMapper userCreateMapper;
  private final UserUpdateMapper userUpdateMapper;
  private final UserServicePort userServicePort;

  @GetMapping()
  public Mono<ResponseEntity<List<UserResponse>>> retrieveAll() {
    return userServicePort
        .findAll()
        .collectList()
        .map(user -> ResponseEntity.ok(userResponseMapper.toListUserResponse(user)))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping(path = "/{id}")
  public Mono<ResponseEntity<UserResponse>> retrieveById(@PathVariable Long id) {
    return userServicePort
        .findById(id)
        .map(user -> ResponseEntity.ok(userResponseMapper.toUserResponse(user)))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping()
  public Mono<ResponseEntity<UserResponse>> saveUser(@Valid @RequestBody UserCreate userCreate) {
    return userServicePort
        .save(userCreateMapper.toUser(userCreate))
        .map(
            user ->
                new ResponseEntity<>(userResponseMapper.toUserResponse(user), HttpStatus.CREATED));
  }

  @PutMapping(path = "/{id}")
  public Mono<ResponseEntity<UserResponse>> userUpdate(
      @PathVariable Long id, @RequestBody UserUpdate userUpdate) {
    return userServicePort
        .update(id, userUpdateMapper.toUserUpdate(userUpdate))
        .map(user -> ResponseEntity.accepted().body(userResponseMapper.toUserResponse(user)))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build())
        .log();
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userServicePort.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
