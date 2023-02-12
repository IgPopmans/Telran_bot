package com.telran.telran_bot.controller;

import com.telran.telran_bot.model.User;
import com.telran.telran_bot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User createdEntity = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdEntity.getId()).toUri();
        return ResponseEntity.created(location).body(createdEntity);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user) {

        try {
            User updatedUser = userService.updateUser(id, user.getName(), user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id) {
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
