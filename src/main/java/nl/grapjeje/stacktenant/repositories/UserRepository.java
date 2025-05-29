package nl.grapjeje.stacktenant.repositories;

import nl.grapjeje.stacktenant.enitity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
