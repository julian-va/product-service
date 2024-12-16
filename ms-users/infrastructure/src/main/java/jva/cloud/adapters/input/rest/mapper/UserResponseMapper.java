package jva.cloud.adapters.input.rest.mapper;

import java.util.List;
import jva.cloud.adapters.input.rest.response.UserResponse;
import jva.cloud.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

  @Mapping(source = "creationDate", target = "creationDate")
  @Mapping(source = "updateDate", target = "updateDate")
  @Mapping(source = "isActive", target = "isActive")
  UserResponse toUserResponse(User user);

  User toUser(UserResponse userResponse);

  List<UserResponse> toListUserResponse(List<User> users);
}
