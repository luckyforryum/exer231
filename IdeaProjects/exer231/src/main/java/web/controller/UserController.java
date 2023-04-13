package web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
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
    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("updateInfo")
    public String edit(@RequestParam("userId") Long id, Model model) {
        User user = userService.getUser(id);

        model.addAttribute("user1",user);
        return "update-info";

    }

    @PatchMapping("/{userId}")
    public String update(@ModelAttribute("user1") User user, @PathVariable("userId") Long id, Model model) {
        userService.update(id, user);
        model.addAttribute("user1",user);
        return "redirect:/";
    }


    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
