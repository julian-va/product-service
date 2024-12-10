package jva.cloud.service;

import jva.cloud.model.User;
import jva.cloud.ports.input.UserServicePort;
import jva.cloud.ports.output.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

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
        return userPersistencePort.findById(id).map(userPersistencePort::save).defaultIfEmpty(Mono.empty()).flatMap(userMono -> userMono);
    }

    @Override
    public void deleteById(Long id) {
        userPersistencePort.findById(id).filter(Objects::nonNull).doOnNext(user -> userPersistencePort.deleteById(user.id()));
    }
}
