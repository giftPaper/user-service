package user.domain.entity.mapper;

import org.springframework.stereotype.Component;
import user.api.dto.UserDto;
import user.domain.entity.UsersEntity;

@Component
public class UsersEntityMapper {
    public UsersEntity map(UserDto userDto){
        return UsersEntity.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .middlename(userDto.getMiddlename())
                .birthDt(userDto.getBirthDt())
                .build();
    }
}
