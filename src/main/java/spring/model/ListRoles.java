package spring.model;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class ListRoles {
    Set<Role> listRoles;

    public ListRoles(Set<Role> listRoles) {
        this.listRoles = listRoles;
    }

    public Set<Role> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<Role> listRoles) {
        this.listRoles = listRoles;
    }

    @Override
    public String toString() {
        return "ListRoles{" +
                "listRoles=" + listRoles +
                '}';
    }
}
