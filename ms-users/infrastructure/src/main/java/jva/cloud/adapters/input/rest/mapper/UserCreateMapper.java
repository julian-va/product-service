package jva.cloud.adapters.input.rest.mapper;

import jva.cloud.adapters.input.rest.request.UserCreate;
import jva.cloud.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserCreateMapper {
  UserCreate toUserCreate(User user);

  @Mapping(source = "isActive", target = "isActive")
  User toUser(UserCreate userCreate);
}
