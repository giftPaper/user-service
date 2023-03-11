package user.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import user.api.dto.PageDto;
import user.api.dto.UserDto;
import user.api.dto.UserFilterDto;
import user.domain.entity.UsersEntity;
import user.service.UserService;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}")
public class UsersController {

    private final UserService userService;

    @GetMapping
    public PageDto get(@ParameterObject UserFilterDto userFilterDto) {
        return userService.getUsers(userFilterDto);
    }

    @GetMapping({"/{id}"})
    public UsersEntity getById(@PathVariable Long id ) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}