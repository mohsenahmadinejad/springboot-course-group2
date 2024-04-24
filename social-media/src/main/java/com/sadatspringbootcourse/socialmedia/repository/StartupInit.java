package com.sadatspringbootcourse.socialmedia.repository;

import com.sadatspringbootcourse.socialmedia.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartupInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.users.add(new User(++userRepository.userCount,"Mohsen", LocalDate.now().minusYears(30)));
        userRepository.users.add(new User(++userRepository.userCount,"Ali", LocalDate.now().minusYears(20)));
        userRepository.users.add(new User(++userRepository.userCount,"Reza", LocalDate.now().minusYears(40)));
    }
}
