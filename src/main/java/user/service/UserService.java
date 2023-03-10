package user.service;


import user.api.dto.PageDto;
import user.api.dto.UserDto;
import user.domain.entity.UsersEntity;

import java.util.List;

public interface UserService {

    PageDto getUsers(int page, int size);

    UsersEntity getUserById(Long id);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
