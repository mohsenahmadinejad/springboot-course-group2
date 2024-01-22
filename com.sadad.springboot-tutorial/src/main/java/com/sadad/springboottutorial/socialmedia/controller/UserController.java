package com.sadad.springboottutorial.socialmedia.controller;

import com.sadad.springboottutorial.socialmedia.entity.User;
import com.sadad.springboottutorial.socialmedia.exception.UserNotFoundException;
import com.sadad.springboottutorial.socialmedia.repository.UserRepository;
import com.sadad.springboottutorial.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //  Retrieve all Users
    @GetMapping ("/users")
    public ResponseEntity< List<User> > getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    //Create a User
    @PostMapping ("/users")
    public ResponseEntity<User> createUser(@RequestBody  User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }


    //    Retrieve one User
    @GetMapping("/users/{id}") //-> /users/1
    public ResponseEntity<User> getUserById(@PathVariable  Integer id){
        User user=userService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException("not Found id: "+id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    //Delete a User
    @DeleteMapping("/users/{id}")// -> /users/1
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
