package com.sadad.springboottutorial.socialmedia.repository;


import com.sadad.springboottutorial.socialmedia.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitStartup implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;




    @Override
    public void run(String... args) throws Exception {
        userRepository.users.add(new User(++userRepository.userCount,"mohsen", LocalDate.now().minusYears(30)));
        userRepository.users.add(new User(++userRepository.userCount,"Ali", LocalDate.now().minusYears(25)));
        userRepository.users.add(new User(++userRepository.userCount,"Reza", LocalDate.now().minusYears(20)));

    }
}
