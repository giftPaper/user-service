package user.service;


import user.api.dto.PageDto;
import user.api.dto.UserDto;
import user.api.dto.UserFilterDto;
import user.domain.entity.UsersEntity;

public interface UserService {

    PageDto getUsers(UserFilterDto userFilterDto);

    UsersEntity getUserById(Long id);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
