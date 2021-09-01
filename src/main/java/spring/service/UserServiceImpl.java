package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDAO;
import spring.model.Role;
import spring.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    @Override
    public List<User> getAll() { return dao.getAll(); }

    @Override
    public void add(User user) { dao.add(user); }

    @Override
    public void update(User user) { dao.update(user);}

    @Override
    public User getUserById(Long id) { return dao.getUserById(id); }

    @Override
    public void delete(Long id) { dao.delete(id); }

//    @Override
//    public void delete(String name) { dao.delete(name); }

    @Override
    public List<Role> getAllRoles() { return dao.getAllRoles(); }

    @Override
    public void deleteRole(Long id) { dao.deleteRole(id); }

    @Override
    public void addRole(String role) { dao.addRole(role); }


}
