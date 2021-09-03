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
@EqualsAndHashCode
@ToString
@Entity
@NamedEntityGraph(name = "User.roles", attributeNodes = @NamedAttributeNode("roles"))
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String name; // уникальное значение
    @Column(nullable=false)
    private String password;
    private String lastName;
    private int age;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return name; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

//    public void setPassword(String password) { this.password = password; }

 //   public Set<Role> getRoles() { return roles; }

    public void addRole(Role role) { this.roles.add(role); }



}
