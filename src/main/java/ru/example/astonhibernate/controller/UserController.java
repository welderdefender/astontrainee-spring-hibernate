package ru.example.astonhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.astonhibernate.model.dto.user.UserDtoRq;
import ru.example.astonhibernate.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userServiceImpl = userService;
    }

    @GetMapping()
    public String getAllUser(Model model) {
        model.addAttribute("users", userServiceImpl.getAllUser());
        return "get-all-users";
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "find-user";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDtoRq());
        return "create-user";
    }

    @PostMapping("/create")
    public String createUser(UserDtoRq userDtoRq) {
        userServiceImpl.saveOrUpdateUser(userDtoRq);
        return "redirect:/user";
    }

    @GetMapping("/update/{id}")
    public String updateWorkerForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(UserDtoRq userDtoRq) {
        userServiceImpl.saveOrUpdateUser(userDtoRq);
        return "redirect:/user";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/user";
    }
}