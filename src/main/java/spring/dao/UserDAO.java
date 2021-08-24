package spring.dao;

import spring.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void add(User user);
    void update(User user);
    User getUserById(Long id);
    void delete(Long id);

}
