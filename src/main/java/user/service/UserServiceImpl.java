package user.service;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import user.api.dto.PageDto;
import user.api.dto.UserDto;
import user.api.dto.UserFilterDto;
import user.api.dto.mapper.UserDtoMapper;
import user.domain.entity.UsersEntity;
import user.domain.entity.mapper.UsersEntityMapper;
import user.exceptions.RestApiException;
import user.domain.repo.UsersRepo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepo usersRepo;
    private final UserDtoMapper userDtoMapper;
    private final UsersEntityMapper usersEntityMapper;

    @Override
    public UserDto create(UserDto userDto) {
        var usersEntity = usersEntityMapper.map(userDto);
        return userDtoMapper.map(usersRepo.save(usersEntity));
    }

    @Override
    public PageDto getUsers(UserFilterDto userFilterDto) {
        PageRequest pageRequest = PageRequest.of(userFilterDto.getPage(), userFilterDto.getSize(), Sort.by("id").descending());
        Page<UsersEntity> usersEntity = usersRepo.findAll(getSpecification(userFilterDto), pageRequest);
        return PageDto.builder()
                .totalPages(usersEntity.getTotalPages())
                .totalElements(usersEntity.getTotalElements())
                .content(usersEntity.getContent().stream()
                        .map(userDtoMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public UsersEntity getUserById(Long id) {
        return usersRepo.findById(id)
                .orElseThrow(() -> new RestApiException(String.format("Пользователь c ID: %s не найден", id)));
    }

    @Override
    public UserDto update(UserDto userDto) {
        var userEntity = usersRepo.findById(userDto.getId())
                .orElseThrow(() -> new RestApiException(String.format("Пользователь с ID: %s не найден", userDto.getId())));
        updateUser(userEntity, userDto);
        return userDtoMapper.map(usersRepo.save(userEntity));
    }

    @Override
    public void delete(Long id) {
        usersRepo.deleteById(id);
    }

    private void updateUser(UsersEntity usersEntity, UserDto userDto) {
        usersEntity.setFirstname(userDto.getFirstname());
        usersEntity.setLastname(userDto.getLastname());
        usersEntity.setMiddlename(userDto.getMiddlename());
        usersEntity.setRole(userDto.getRole());
        usersEntity.setBirthDt(userDto.getBirthDt());
    }

    public Specification<UsersEntity> getSpecification(UserFilterDto userFilterDto) {

        return (root, query, criteriaBuilder) -> {
            List<String> search = Arrays.stream(userFilterDto.getSearchBy().toLowerCase().split(" ")).toList();
            Predicate[] predicates = new Predicate[search.size()];
            for (int i = 0; i < search.size(); i++) {
                predicates[i] = criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("firstname")), "%" + search.get(i) + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("lastname")),"%" + search.get(i) + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("middlename")), "%" + search.get(i) + "%")
                        );
            }
            return criteriaBuilder.and(predicates);
        };
    }
}