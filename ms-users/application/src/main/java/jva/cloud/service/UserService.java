package jva.cloud.service;

import java.util.Objects;
import jva.cloud.model.User;
import jva.cloud.ports.input.UserServicePort;
import jva.cloud.ports.output.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserService implements UserServicePort {
  private final UserPersistencePort userPersistencePort;

  @Override
  public Mono<User> findById(Long id) {
    return userPersistencePort.findById(id);
  }

  @Override
  public Flux<User> findAll() {
    return userPersistencePort.findAll();
  }

  @Override
  public Mono<User> save(User user) {
    return userPersistencePort.save(user);
  }

  @Override
  public Mono<User> update(Long id, User user) {
    return userPersistencePort
        .findById(id)
        .map(
            userFind -> {
              User userToUpdate =
                  userFind.toBuilder()
                      .email(Objects.nonNull(user.email()) ? user.email() : userFind.email())
                      .name(Objects.nonNull(user.name()) ? user.name() : userFind.name())
                      .isActive(
                          Objects.nonNull(user.isActive()) ? user.isActive() : userFind.isActive())
                      .build();
              return userPersistencePort.save(userToUpdate);
            })
        .defaultIfEmpty(Mono.empty())
        .flatMap(userMono -> userMono);
  }

  @Override
  public void deleteById(Long id) {
    userPersistencePort
        .findById(id)
        .filter(Objects::nonNull)
        .doOnNext(user -> userPersistencePort.deleteById(user.id()))
        .log(String.format("user id to delete %s", id));
  }
}
