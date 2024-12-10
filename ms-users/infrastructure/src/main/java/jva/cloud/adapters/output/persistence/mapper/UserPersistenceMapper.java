package jva.cloud.adapters.output.persistence.mapper;

import jva.cloud.adapters.output.persistence.entity.UserEntity;
import jva.cloud.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    UserEntity toUserEntity(User user);

    User toSUser(UserEntity userEntity);

    List<User> toUserList(List<UserEntity> userEntityList);
}
