package jva.cloud.config;

import jva.cloud.ports.input.UserServicePort;
import jva.cloud.ports.output.UserPersistencePort;
import jva.cloud.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateDependence {

    @Bean
    UserServicePort bindingToUserServicePort(UserPersistencePort userPersistencePort) {
        return new UserService(userPersistencePort);
    }
}
