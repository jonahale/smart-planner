package com.jonah.planner.service;
import com.jonah.planner.UserMapper;
import com.jonah.planner.domain.User;
import com.jonah.planner.exception.UserNotFoundException;
import com.jonah.planner.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByID(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)); // If user doesn't exist throw an error
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserByID(id);
        existingUser.setName(updatedUser.getName());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        getUserByID(id);
        userRepository.deleteById(id);
    }

}
