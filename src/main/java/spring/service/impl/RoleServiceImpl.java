package spring.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.model.Role;
import spring.repository.RoleRepository;
import spring.service.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() { return roleRepository.findAll(); }
    @Override
    public Role getRoleById(Long id) { return roleRepository.findById(id).orElse(null); }
    @Override
    public void deleteRoleById(Long id) { roleRepository.deleteById(id); }
    @Override
    public Role getRoleByName(String role) { return roleRepository.findByRole(role).orElse(null); }
    @Override
    public void addRoleByName(String role) {
        if (getRoleByName(role) != null) {
            System.out.println("Duplication of role: "+ role);
            return;
        }
        roleRepository.save(new Role(role));
    }
}
