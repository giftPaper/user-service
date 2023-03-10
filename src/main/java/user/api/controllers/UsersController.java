package user.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.api.dto.PageDto;
import user.api.dto.UserDto;
import user.domain.entity.UsersEntity;
import user.domain.repo.UsersRepo;
import user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}")
public class UsersController {

    private final UserService userService;

    @GetMapping
    public PageDto get(@RequestParam int page, @RequestParam int size) {
        return userService.getUsers(page, size);
    }

    @GetMapping({"/{id}"})
    public UsersEntity get(@PathVariable Long id ) {
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