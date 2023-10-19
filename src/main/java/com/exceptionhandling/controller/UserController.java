package com.exceptionhandling.controller;

import com.exceptionhandling.dto.UserRequest;
import com.exceptionhandling.entity.User;
import com.exceptionhandling.exception.ResourceNotFoundException;
import com.exceptionhandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
   private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest) {

        User user = userService.saveUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) throws ResourceNotFoundException {

        return ResponseEntity.ok(userService.getUser(userId));

    }


}
