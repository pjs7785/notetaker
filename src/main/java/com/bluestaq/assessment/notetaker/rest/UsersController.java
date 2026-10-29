package com.bluestaq.assessment.notetaker.rest;

import com.bluestaq.assessment.notetaker.data.User;
import com.bluestaq.assessment.notetaker.exceptions.InvalidUsernameException;
import com.bluestaq.assessment.notetaker.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/getUser/{username}")
    public User getUserByUserName(@PathVariable("username") String username) {
        //TODO: add validation in the service, and return a ResponseEntity here
        return usersService.getUserByUserName(username);
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        //TODO: add validation in the service, and return a ResponseEntity here
        usersService.createUser(user);
    }

    @DeleteMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        //TODO: replace the returning of a string status message with a ResponseEntity<Note>,
        // after figuring out how to do that for Spring Boot
        String statusMessage;

        try {
            usersService.deleteUser(username);
            statusMessage = "success";
        } catch (InvalidUsernameException e) {
            statusMessage = e.getMessage();
        }

        return statusMessage;
    }
}
