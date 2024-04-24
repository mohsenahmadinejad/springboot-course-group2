package com.sadatspringbootcourse.socialmedia.service;

import com.sadatspringbootcourse.socialmedia.entity.User;
import com.sadatspringbootcourse.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return  userRepository.users;
    }

//    //    Create a User
    public  User saveUser(User user){
        user.setId(++userRepository.userCount);
//        userRepository.users.add(new User(user.getId(),user.getName(),user.getBirthDate())new User(user.getId(),user.getName(),user.getBirthDate()));
        userRepository.users.add(user);
        return user ;
    }
//
//    //    Retrieve one User
    @GetMapping("/users/{id}") // -> /users/1
    public User getUserById(int id){

        return userRepository.users.
                stream().
                filter(user -> user.getId()==id).
                findFirst().
                orElse(null) ;
    }
//    //    Delete a User
    public void deleteUserById(  int id){
        userRepository.users.removeIf(user -> user.getId()==id);
    }
}
