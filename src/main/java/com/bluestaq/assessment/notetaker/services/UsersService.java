package com.bluestaq.assessment.notetaker.services;

import com.bluestaq.assessment.notetaker.data.User;
import com.bluestaq.assessment.notetaker.exceptions.InvalidUsernameException;
import com.bluestaq.assessment.notetaker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) throws InvalidUsernameException {
        User user = getUserByUserName(username);

        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new InvalidUsernameException(username);
        }
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
