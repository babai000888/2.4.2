package spring.service;


import spring.model.Role;
import spring.model.User;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    Role getRoleById(Long id);
    void deleteRole(Long id);
    Role getRoleByName(String role);
    void addRole(String role);
}


