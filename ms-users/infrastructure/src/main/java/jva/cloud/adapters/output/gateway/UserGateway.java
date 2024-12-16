package jva.cloud.adapters.output.gateway;

import jva.cloud.adapters.output.persistence.mapper.UserPersistenceMapper;
import jva.cloud.adapters.output.persistence.repository.UserRepository;
import jva.cloud.model.User;
import jva.cloud.ports.output.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserGateway implements UserPersistencePort {
  private final UserRepository userRepository;
  private final UserPersistenceMapper userPersistenceMapper;

  @Override
  public Mono<User> findById(Long id) {
    return userRepository
        .findById(id)
        .map(userPersistenceMapper::toSUser)
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Flux<User> findAll() {
    return userRepository.findAll().map(userPersistenceMapper::toSUser);
  }

  @Override
  public Mono<User> save(User user) {
    return userRepository
        .save(userPersistenceMapper.toUserEntity(user))
        .map(userPersistenceMapper::toSUser)
        .log();
  }

  @Override
  public void deleteById(Long id) {
    userRepository
        .findById(id)
        .hasElement()
        .doOnNext(
            monoEmpty -> {
              if (!monoEmpty) {
                userRepository.deleteById(id);
              }
            });
  }
}
