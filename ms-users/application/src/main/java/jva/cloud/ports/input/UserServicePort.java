package jva.cloud.ports.input;

import jva.cloud.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserServicePort {
    Mono<User> findById(Long id);

    Flux<User> findAll();

    Mono<User> save(User user);

    Mono<User> update(Long id, User user);

    void deleteById(Long id);
}
