package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.model.User;
import spring.repository.UserRepository;
import spring.service.RoleService;
import spring.service.UserService;

import java.util.List;
import java.util.Set;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("*********************************************");
        roleService.addRoleByName("ROLE_ADMIN");
        roleService.addRoleByName("ROLE_USER");

        User admin = new User();
 //       admin.setId(1L);
        admin.setName("admin");
        admin.setPassword("admin");
 //       admin.setLastName("INIT");
//        admin.setAge(50);
        admin.setRoles(Set.of(roleService.getRoleByName("ROLE_ADMIN"),roleService.getRoleByName("ROLE_USER")));
        System.out.println(admin);
        userService.saveUser(admin);

        User user = new User();
        user.setName("user");
        user.setPassword("user");
        user.setRoles(Set.of(roleService.getRoleByName("ROLE_USER")));
        userService.saveUser(user);

        System.out.println("==========================================================");
        System.out.println(admin + "\n" + user);
        System.out.println("==========================================================");
    }
}