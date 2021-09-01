package spring.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "users")
@Entity
@NamedEntityGraph(name = "User.roles", attributeNodes = @NamedAttributeNode("roles"))
public class User implements UserDetails {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // уникальное значение
    private String password;
    private String lastName;
    private int age;
    @ManyToMany
    @JoinTable(name = "user_role"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String name, String password, String lastName, int age) {
        this.name = name;
        this.password = password;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }


//    public String getRolesToString() {
//        StringBuilder sb = new StringBuilder("ROLES");
//        System.out.println("AAAAAAAAAAAAAAAA");
//        System.out.println("name   " + name);
//        System.out.println("ROLES    "+ getLastName());
// //       roles.stream().forEach(x -> sb.append("{").append(x.getRole()).append("}"));
////        System.out.println("RRRRRRRRROLES" + sb.toString());
//        return sb.toString();
//    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
