package Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.model.User;
import Backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean registerUser(User user) {
        if (userRepository.findByEmail(user.getEmailUser()) == null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
