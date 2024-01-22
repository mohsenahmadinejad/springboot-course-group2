package com.sadad.springboottutorial.socialmedia.service;

import com.sadad.springboottutorial.socialmedia.entity.User;
import com.sadad.springboottutorial.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //  Retrieve all Users

    public List<User> getAllUsers(){
        return userRepository.users;
    }

    //Create a User
    public User createUser(User user){
        user.setId(++userRepository.userCount);
        userRepository.users.add(user);
        return user;
    }


    //    Retrieve one User
    public User getUserById(Integer id){
        return userRepository.users.
                stream().
                filter(user -> user.getId()==id).
                findFirst().
                orElse(null);
    }

    //Delete a User
    public void deleteUserById(Integer id){
        userRepository.users.removeIf(user -> user.getId()==id);
        return;
    }
}
