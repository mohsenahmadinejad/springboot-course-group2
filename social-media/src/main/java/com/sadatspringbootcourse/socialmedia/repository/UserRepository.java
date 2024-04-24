package com.sadatspringbootcourse.socialmedia.repository;

import com.sadatspringbootcourse.socialmedia.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    public int userCount=0;
    public List<User>  users =new ArrayList<>();

}
