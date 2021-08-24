package spring.service;

import spring.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void add(User user);
    void update(User user);
    User getUserById(Long id);
    void delete(Long id);
}
