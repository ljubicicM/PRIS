package Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import Backend.model.User;
import Backend.repositories.UserRepository;

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

    public User loginUser(String userEmail, String passwordUser) {
        if (userRepository.findByEmail(userEmail) == null) {
            return null;
        }

        User user = userRepository.findByEmail(userEmail);

        if (passwordEncoder.matches(passwordUser, user.getPasswordUser())) {
            return user;
        }

        return null;
    }

    public void initAdmin() {
        User admin = new User();
        admin.setEmailUser("admin@admin.admin");
        admin.setPasswordUser(passwordEncoder.encode("admin"));
        admin.setRoleUser("admin");
        admin.setUsernameUser("admin");
        admin.setPhoneUser("1234567890");
        this.registerUser(admin);
    }
}
