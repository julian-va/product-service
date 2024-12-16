package jva.cloud.adapters.input.rest.mapper;

import jva.cloud.adapters.input.rest.request.UserUpdate;
import jva.cloud.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserUpdateMapper {
  @Mapping(source = "isActive", target = "isActive")
  User toUserUpdate(UserUpdate userUpdate);
}
