package antifraud.controller.api;

import antifraud.controller.responce.UserResponse;
import antifraud.jpa.UserRepository;
import antifraud.pojo.User;
import antifraud.service.UserDetailsImpl;
import antifraud.service.UserDetailsServiceImpl;
import antifraud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserDetailsServiceImpl userService;

    @Autowired
    UserServiceImpl userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/test")
    public String test() {
        return "You`ve been authorized, welcome!";
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userService.createUser(new UserDetailsImpl(user));

        return UserResponse.createResponse(savedUser,HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> allUsers() {
        return UserResponse.createResponse(userRepository.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/user/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
        userRepository.deleteByUsername(username);
        return new ResponseEntity<>(Map.of(
                "username",username,
                "status","Deleted successfully!"),HttpStatus.OK);
    }

}
