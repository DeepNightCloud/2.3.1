package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {

        model.addAttribute("allUs", userService.getAllUsers());

        return "all-users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "user-show";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("userAdd",new User());
        return "user-add";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("userAdd") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("userAdd", userService.showUser(id));
        return "user-edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("userAdd") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deletedUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
