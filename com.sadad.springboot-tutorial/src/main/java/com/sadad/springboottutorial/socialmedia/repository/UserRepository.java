package com.sadad.springboottutorial.socialmedia.repository;


import com.sadad.springboottutorial.socialmedia.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    // jpa//hibernate -> database
    public  int userCount=0;
    public List<User> users=new ArrayList<>();


}
