package spring;

import org.springframework.stereotype.Component;
import spring.model.Role;
import spring.model.User;
import spring.service.RoleService;
import spring.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
public class DBInitializer {
//    private final UserService userService;
//    private final RoleService roleService;
//
//    public DBInitializer(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @PostConstruct
//    private void init() {
//        roleService.addRole("ROLE_ADMIN");
//        roleService.addRole("ROLE_USER");
//
//        User admin = new User("admin","admin");
//        userService.save(admin,List.of(roleService.getRoleByName("ROLE_ADMIN").getId()));
//
//        // проверяем что юзеры и роли ушли в базу
//        System.out.println("==============================================");
//        System.out.println(admin);
//        System.out.println("==============================================");
//    }
}
