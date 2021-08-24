package spring.dao.impl;

import org.springframework.stereotype.Component;
import spring.dao.UserDAO;
import spring.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class JpaUserDAO implements UserDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAll()  { return entityManager.createQuery("SELECT user FROM User user").getResultList(); }

    @Override
    public void add(User user) { entityManager.persist(user); }

    @Override
    public void update(User user) { entityManager.merge(user); }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) { entityManager.remove(getUserById(id)); }
}
