package spring.service;

import spring.model.Role;
import spring.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void add (User user, List<Long> id);
    void save(User user, List<Long> id);
    User getUserById(Long id);
    void delete(Long id);
}
