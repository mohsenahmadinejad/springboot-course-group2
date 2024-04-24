package com.sadatspringbootcourse.socialmedia.controller;


import com.sadatspringbootcourse.socialmedia.entity.User;
import com.sadatspringbootcourse.socialmedia.exception.UserNotFoundException;
import com.sadatspringbootcourse.socialmedia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
   // Retrieve all Users

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
//        return  userRepository.users;
        return  ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

//    Create a User
    @PostMapping
    @Operation(
            summary = "Create a new user",
            description = "Create new user",
            responses ={
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Bad request",
                            responseCode = "400"
                    )
            }

    )
     public  ResponseEntity<User> saveUser(@Valid  @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user) );
    }

//    Retrieve one User
    @GetMapping("/{id}") // -> /users/1
    public ResponseEntity<User> getUserById(@PathVariable  Integer id){
        User user=userService.getUserById(id);
        if (user==null){
            throw new UserNotFoundException("id: "+id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user );
    }
//    Delete a User
    @DeleteMapping("/{id}")// -> /users/1
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
