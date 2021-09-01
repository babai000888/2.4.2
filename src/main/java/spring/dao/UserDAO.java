package spring.dao;

import spring.model.Role;
import spring.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    boolean add(User user);
    void update(User user);
    User getUserById(Long id);
    void delete(Long id);
//    void delete(String name);
    User getUserByName(String name);

    List<Role> getAllRoles();
    Role getRoleById(Long id);
    void deleteRole(Long id);
    Role getRoleByName(String name);
    boolean addRole(String role);

}
