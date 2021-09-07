package spring.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.model.User;
import spring.repository.UserRepository;
import spring.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public void addUser(User user) {
        if (userRepository.findUserByName(user.getName()).orElse(null) != null) {
            System.out.println("Duplication of user: "+ user);
            return;
        }
        saveUser(user);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    private User encodePassword(User user) {
        if(user.getId() != null) System.out.println(userRepository.findById(user.getId()).orElse(null).getPassword());
        if(user.getId() == null || user.getPassword() != userRepository.findById(user.getId()).orElse(null).getPassword())
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public void saveUser(User user) { userRepository.save(encodePassword(user)); }

    @Override
    public User getUserById(Long id) { return userRepository.findById(id).orElse(null); }

    @Override
    public void deleteUserById(Long id) { userRepository.deleteById(id); }
}
