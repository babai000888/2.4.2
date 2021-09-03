package spring.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDao;
import spring.model.Role;
import spring.model.User;
import spring.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public List<User> getAll() { return dao.getAll(); }

    @Override
    public void add (User user, List<Long> id) { dao.add(user,id); }

    @Override
    public void save(User user, List<Long> id) { dao.save(user,id); }

    @Override
    public User getUserById(Long id) { return dao.getUserById(id); }

    @Override
    public void delete(Long id) { dao.delete(id); }


}
