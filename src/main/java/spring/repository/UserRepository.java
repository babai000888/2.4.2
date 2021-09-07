package spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import spring.model.User;
import spring.security.SecurityConfig;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @EntityGraph(value = "User.roles")
    Optional<User> findUserByName (String name);
    @EntityGraph(value = "User.roles")
    List<User> findAll();
    @EntityGraph(value = "User.roles")
    Optional<User> findById(Long Id);
}
