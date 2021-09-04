package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.dao.RoleDao;
import spring.model.Role;
import spring.repository.RoleRepository;
import spring.repository.UserRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Component
public class RoleDaoImpJPA implements RoleDao {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() { return roleRepository.findAll(); }

    @Override
    public Role getRoleById (Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRole (Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRoleByName (String role) {
        return roleRepository.findRoleByRole(role).orElse(null);
    }

    @Override
    public boolean addRole(String role) {
        if (getRoleByName(role) != null) {
            return false;
        }
        roleRepository.save(new Role(role));
        return true;
    }

}
