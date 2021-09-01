package spring.service;

import spring.model.Role;
import spring.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void add(User user);
    void update(User user);

    User getUserById(Long id);
    void delete(Long id);
//    void delete(String name);

    List<Role> getAllRoles();
    void deleteRole(Long id);
    void addRole(String role);
}
