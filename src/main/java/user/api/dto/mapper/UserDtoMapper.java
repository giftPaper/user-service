package user.api.dto.mapper;

import org.springframework.stereotype.Component;
import user.api.dto.UserDto;
import user.domain.entity.UsersEntity;

@Component
public class UserDtoMapper {

    public UserDto map(UsersEntity usersEntity){

        return UserDto.builder()
                .id(usersEntity.getId())
                .firstname(usersEntity.getFirstname())
                .lastname(usersEntity.getLastname())
                .middlename(usersEntity.getMiddlename())
                .birthDt(usersEntity.getBirthDt())
                .build();
    }
}
