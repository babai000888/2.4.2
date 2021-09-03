package spring.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findUserByName (String name);
    @EntityGraph(value = "User.roles")
    List<User> getAllByIdIsNotNull();
    @EntityGraph(value = "User.roles")
    Optional<User> findUserByIdIsNotNull();
}
