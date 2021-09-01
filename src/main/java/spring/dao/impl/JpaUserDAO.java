package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDAO;
import spring.model.Role;
import spring.model.User;
import spring.repository.RoleRepository;
import spring.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class JpaUserDAO implements UserDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public List<User> getAll() {
//        return entityManager.createQuery("SELECT user FROM User user").getResultList();
//    }

    @Override
    public List<User> getAll() {
        return userRepository.getAllByIdIsNotNull();
    }


    private User encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public boolean add(User user) {
        if (getUserByName(user.getName()) != null) {
            return false;
        }
//        addRole("USER");
//        user.setRoles(Set.of(getRoleByName("USER")));
        System.out.println("AAAAAAAAAAAADD!"+user);
        System.out.println(user.getRoles());
     //   System.out.println(user.getRolesToString());
        userRepository.save(encodePassword(user));
 //       entityManager.persist(encodePassword(user));
        return true;
    }

    @Override
    public void update(User user) {
        System.out.println("MMMMMMMMMMERGE!" +user.toString());
 //       entityManager.merge(encodePassword(user));
        userRepository.save(encodePassword(user));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
 //       return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
 //       entityManager.remove(getUserById(id));
    }

//    @Override
//    public void delete(String name) { entityManager.remove(getUserByName(name)); }


    //    private final Map<String, User> userMap = Collections.singletonMap("test",
//            new User(1L, "name", "password", "lastName", 100, Collections.singleton(new UserRole("ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
//
//    @Override
//    public User getUserByName(String name) {
//        try {
//            return (User) entityManager.createQuery("SELECT user FROM User user WHERE user.name = :param")
//                    .setParameter("param", name)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            System.out.println("no user " + name);
//            return null;
//        }
//    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name).orElse(null);
    }


//    @Override
//    public User getUserByName(String name) {return entityManager.find(User.class, name); }

//
//    @Override
//    public List<Role> getAllRoles() {
//        return entityManager.createQuery("SELECT role FROM Role role").getResultList();
//    }

    @Override
    public List<Role> getAllRoles() { return roleRepository.findAll(); }



//    public List<String> getAllStringRoles() {
//        List list = new ArrayList<String>();
//            getAllRoles().stream().forEach(x -> list.add(x.getRole()));
//            return list;
//    }

//    @Override
//    public Role getRoleById(Long id) {
//        return entityManager.find(Role.class, id);
//    }

    @Override
    public Role getRoleById (Long id) {
        return roleRepository.findById(id).orElse(null);
    }

//    @Override
//    public void deleteRole(Long id) {
//        entityManager.remove(getRoleById(id));
//    }

    @Override
    public void deleteRole (Long id) {
        roleRepository.deleteById(id);
    }

//    @Override
//    public void deleteRole(String role) {
//        entityManager.remove(getRoleByName(role));
//    }


//    @Override
//    public Object getRoleByName(String name) {
//        return entityManager.createQuery("SELECT role FROM UserRole role WHERE role.userRole = :param")
//                .setParameter("param", name)
//                .getSingleResult();
//    }

//    @Override
//    public Role getRoleByName(String name) {
//        try {
//            return (Role) entityManager.createQuery("SELECT role FROM Role role WHERE role.role = :param")
//                    .setParameter("param", name)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            System.out.println("no role " + name);
//            return null;
//        }
//    }
    @Override
    public Role getRoleByName (String name) {
        return roleRepository.findRoleByRole(name).orElse(null);
    }

//    @Override
//    public Role getRoleByName(String role) {return entityManager.find(Role.class, role); }



    @Override
    public boolean addRole(String role) {
        if (getRoleByName(role) != null) {
            return false;
        }
//        entityManager.persist(role);
        roleRepository.save(new Role(role));
        return true;
    }

}
