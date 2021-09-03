package spring.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

// Этот класс реализует интерфейс GrantedAuthority, в котором необходимо переопределить только один метод getAuthority() (возвращает имя роли).
// Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode (exclude = {"role"})
@Table(name = "roles")
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "roles")
    private String role;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() { return this.role; }

    @Override
    public String getAuthority() { return role; }
}

