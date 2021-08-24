package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.model.User;
import spring.service.UserService;

@Controller
public class EditController {

    @Autowired
    private UserService userService;

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
