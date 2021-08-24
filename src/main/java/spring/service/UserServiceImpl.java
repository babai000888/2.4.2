package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDAO;
import spring.dao.impl.JpaUserDAO;
import spring.model.User;
import spring.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserDAO dao;

    @Override
    public List<User> getAll() { return dao.getAll(); }

    @Override
    @Transactional
    public void add(User user) { dao.add(user); }

    @Override
    @Transactional
    public void delete(int id) { dao.delete(id); }

}
