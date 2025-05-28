package nl.grapjeje.stacktenant.services;

import nl.grapjeje.stacktenant.models.User;
import nl.grapjeje.stacktenant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
