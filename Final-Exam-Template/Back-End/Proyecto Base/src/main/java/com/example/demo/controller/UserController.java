package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    // Get para el metodo CRUD general
    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> retrieveAll() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    // Metodos GET, POST, PUT, DELETE
    // GET Particular
    @GetMapping("/users/{userId}")
    public Optional<UserModel> getUser(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    // POST
    @PostMapping("/users")
    public ResponseEntity<UserModel> create(@RequestBody UserModel newUser) {
        userService.createUser(newUser);

        return ResponseEntity.ok().body(newUser);
    }

    // PUT
    @PutMapping("/users/{userId}/{comment}")
    public ResponseEntity<String> updateComment(@PathVariable Long userId, @PathVariable String comment) {

        userService.updateComment(comment, userId);
        return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
