package jva.cloud.ports.output;

import jva.cloud.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserPersistencePort {
    Mono<User> findById(Long id);

    Flux<User> findAll();

    Mono<User> save(User user);

    void deleteById(Long id);
}
