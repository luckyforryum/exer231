package com.chong.SpringBoot312ver2.controller;


import com.chong.SpringBoot312ver2.entity.User;
import com.chong.SpringBoot312ver2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/showAllUser")
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "user-info";
    }

    @PostMapping("/addNewUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/showAllUser";
    }

    @GetMapping("/update-info/{userId}")
    public String edit(@PathVariable("userId") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user1",user);
        return "/update-info";
    }

    @PatchMapping("/update-info1")
    public String update(@ModelAttribute("user1") User user) {
        userService.saveUser(user);
        return "redirect:/showAllUser";
    }


    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/showAllUser";
    }
}
