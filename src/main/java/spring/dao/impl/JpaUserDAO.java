package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDAO;
import spring.model.User;
import spring.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class JpaUserDAO implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAll()  { return userRepository.findAll(); }

    @Override
    @Transactional
    public void add(User user) { userRepository.save(user); }

    @Override
    public void delete(int id) { userRepository.deleteById(id); }
}
