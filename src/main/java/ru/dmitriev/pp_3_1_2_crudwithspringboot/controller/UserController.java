package ru.dmitriev.pp_3_1_2_crudwithspringboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dmitriev.pp_3_1_2_crudwithspringboot.model.User;
import ru.dmitriev.pp_3_1_2_crudwithspringboot.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/add-user")
    public String add(@ModelAttribute("user") User user) {
        return "/add-user";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/add-user";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit-user/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit-user";
    }

    @PatchMapping("/edit-user")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit-user";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/edit-user/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
