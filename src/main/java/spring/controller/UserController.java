package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.User;
import spring.model.Role;
import spring.service.RoleService;
import spring.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // Admin page + delete user

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
        model.addAttribute(new User());
        model.addAttribute("listRoles", roleService.getAllRoles());
        model.addAttribute("action", "addUser");
        return "user_form";
    }

    @PostMapping("/addUser")
    public String addUser (User user, @RequestParam(value = "checkedRoles"
            , required = false) List<Long> id) {
        userService.add(user,id);
        return "redirect:/";
    }

    // Edit user page

    @GetMapping("/edit")
    private String editUser (Model model, Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listRoles", roleService.getAllRoles());
        model.addAttribute("action", "editUser");
        return "edit_form";
    }

    @PostMapping("/editUser")
    public String updateUser(User user, @RequestParam(value = "checkedRoles"
            , required = false) List<Long> id) {
        userService.save(user,id);
        return "redirect:/";
    }

// Edit roles page

    @GetMapping("/roles")
    public String editRoles(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("newRole", new Role());
        return "roles";
    }

    @GetMapping("/deleteRole")
    private String deleteRole( Long id ) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }

    @PostMapping("/addRole")
    public String roleAdd(String role) {
        roleService.addRole(role);
        return "redirect:/roles";
    }
}
