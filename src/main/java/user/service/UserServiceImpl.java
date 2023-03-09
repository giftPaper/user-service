package user.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user.api.dto.UserDto;
import user.api.dto.mapper.UserDtoMapper;
import user.domain.entity.UsersEntity;
import user.domain.entity.mapper.UsersEntityMapper;
import user.domain.repo.UsersRepo;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UsersRepo usersRepo;
    private final UserDtoMapper userDtoMapper;
    private final UsersEntityMapper usersEntityMapper;

    @Override
    public UserDto create(UserDto userDto) {
        var usersEntity = usersEntityMapper.map(userDto);
        return userDtoMapper.map(usersRepo.save(usersEntity));
    }

    @Override
    public List<UserDto> getUsers() {
        return usersRepo.findAll(Sort.by("id").descending())
                .stream()
                .map(userDtoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        return usersRepo.findById(id)
                .map(userDtoMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
    }

    @Override
    public UserDto update(UserDto userDto) {
       var userEntity = usersRepo.findById(userDto.getId()).orElseThrow(
               () -> new EntityNotFoundException(String.format("Пользователь с ID %s не найден", userDto.getId())));
       updateUser(userEntity, userDto);
       return userDtoMapper.map(usersRepo.save(userEntity));
    }

    @Override
    public void delete(Long id) {
        usersRepo.deleteById(id);
    }

    private void updateUser(UsersEntity usersEntity, UserDto userDto){
        usersEntity.setFirstname(userDto.getFirstname());
        usersEntity.setLastname(userDto.getLastname());
        usersEntity.setMiddlename(userDto.getMiddlename());
        usersEntity.setBirthDt(userDto.getBirthDt());
    }
}
