package jva.cloud.adapters.output.persistence.repository;

import jva.cloud.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
