package Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import Backend.model.User;
import Backend.repositories.UserRepository;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean registerUser(User user) {
        if (userRepository.findByEmail(user.getEmailUser()) == null) {
            user.setPasswordUser(passwordEncoder.encode(user.getPasswordUser()));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Boolean loginUser(String userEmail, String passwordUser){
        if(userRepository.findByEmail(userEmail) == null)
            return false;

        User user = userRepository.findByEmail(userEmail);

        if(Objects.equals(user.getPasswordUser(), passwordUser))
            return false;

        return true;
    }
}
