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
    public boolean registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/login")
    public User loginUser(@RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        return userService.loginUser(email, password);
    }

    @PostMapping("/initAdmin")
    public void initAdmin() {
        userService.initAdmin();
    }

}
