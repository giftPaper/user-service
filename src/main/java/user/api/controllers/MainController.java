package user.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import user.domain.repo.UsersRepo;

@Controller
public class MainController {
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/")
    public String user() {
        return "user";
    }
}