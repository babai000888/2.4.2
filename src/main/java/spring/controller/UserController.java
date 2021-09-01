package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.dao.impl.JpaUserDAO;
import spring.model.User;
import spring.model.Role;
import spring.service.UserService;

@Controller
public class UserController {

// Admin page + delete user
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin";
    }

    @GetMapping("/delete")
    private String deleteUser( Long id ) {
        userService.delete(id);
        return "redirect:/";
    }

// Add new user page
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("listRoles", userService.getAllRoles());
        System.out.println(userService.getAllRoles());
        model.addAttribute("action", "/addUser");
        return "usfo_new";
    }

    @PostMapping("/addUser")
    public String userAdd(User user) {
        System.out.println("UUSER" + user.toString());
        System.out.println("RROOLES" + user.getRoles());
        userService.add(user);
        return "redirect:/";
    }

// Edit user page
    @GetMapping("/edit")
    private String editForm(Model model, Long id ) {
        model.addAttribute("newUser", userService.getUserById(id));
        model.addAttribute("listRoles", userService.getAllRoles());
        model.addAttribute("action", "/editUser");
        return "usfo_new";
    }

    @PostMapping("/editUser")
    public String saveUser(User user) {
        userService.update(user);
        return "redirect:/";
    }

// Edit roles page
    @GetMapping("/roles")
    public String getRoles(Model model) {
        model.addAttribute("roles", userService.getAllRoles());
        model.addAttribute("newRole", new Role());
        return "roles";
    }

//    @GetMapping("/deleteRole")
//    private String deleteRole( @RequestParam Long id) {
//        System.out.println("iiiiiiiiiiiiiiiid" + id);
//        userService.deleteRole(id);
//        return "redirect:/roles";
//    }

    @GetMapping("/deleteRole")
    private String deleteRole( Long id ) {
        System.out.println("iiiiiiiiiiiiiiiid" + id);
        userService.deleteRole(id);
        return "redirect:/roles";
    }

    @PostMapping("/addRole")
    public String roleAdd(String role) {
        System.out.println(role);
        userService.addRole(role);
        return "redirect:/roles";
    }

}
