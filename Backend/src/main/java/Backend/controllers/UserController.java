package Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Backend.model.User;
import Backend.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @GetMapping("/login")
    public void loginUser(@RequestBody String passwordUser, String emailUser) {
        userService.loginUser(emailUser, passwordUser);
    }

}
