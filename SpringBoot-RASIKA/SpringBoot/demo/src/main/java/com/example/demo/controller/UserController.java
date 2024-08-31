package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUser() {
        List<User> userList = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @PutMapping("/updateUser/{id}") 
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) { 
        User updatedUser = userService.updateUser(user, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
    }

    @DeleteMapping("/deleteUser/{id}") // Fixed path variable syntax
    public ResponseEntity<String> deleteUser(@PathVariable int id) { // Corrected to @PathVariable
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // No Content typically has no body
    }
}
