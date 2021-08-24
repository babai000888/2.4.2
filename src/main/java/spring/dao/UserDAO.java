package spring.dao;

import spring.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void add(User user);
    void delete(int id);
}
