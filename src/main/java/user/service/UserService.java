package user.service;


import user.api.dto.UserDto;
import user.domain.entity.UsersEntity;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UsersEntity getUserById(Long id);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
