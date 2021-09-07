package spring.service;

import spring.model.Role;
import spring.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    void saveUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
}
