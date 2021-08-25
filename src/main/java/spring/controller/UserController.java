package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.User;
import spring.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "show-delete";
    }

    @GetMapping("/delete")
    private String deleteUser( Long id ) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String submitForm(Model model) {
        model.addAttribute("add", new User());
        return "add";
    }

    @PostMapping("/add")
    public String userSubmit(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    private String editForm(Model model, Long id ) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveUser(User user) {
        userService.update(user);
        return "redirect:/";
    }
}
