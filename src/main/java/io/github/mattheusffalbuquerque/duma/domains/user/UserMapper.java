package io.github.mattheusffalbuquerque.duma.domains.user;

import org.mapstruct.Mapper;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.user.dto.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public User toEntity(User user);

    public UserResponse toResponse(User user);

    public List<UserResponse> toResponseList(List<User> users);
}
