package spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Role;
import spring.model.User;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @EntityGraph(value = "User.roles")
    Optional<User> findUserByName (String name);
    @EntityGraph(value = "User.roles")
    List<User> getAllByIdIsNotNull();
    @EntityGraph(value = "User.roles")
    Optional<User> getUserByIdOrId(Long id,Long id1);
}
