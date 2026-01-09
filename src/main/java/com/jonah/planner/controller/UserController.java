package com.jonah.planner.controller;

import com.jonah.planner.domain.User;
import com.jonah.planner.exception.UserNotFoundException;
import com.jonah.planner.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    private final UserRepository userrepository;

    UserController(UserRepository userRepository) {
        this.userrepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all() {
        return userrepository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userrepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return userrepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userrepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setRole(newUser.getRole());
                    return userrepository.save(user);
                })
                .orElseGet(() -> {
                    return userrepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userrepository.deleteById(id);
    }

}
