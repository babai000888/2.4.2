package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.User;
import spring.service.UserService;

@Controller
public class UserFormController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String submitForm(Model model) {
        model.addAttribute("form", new User());
        return "form";
    }

    @PostMapping("/form")
    public String userSubmit(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
}


