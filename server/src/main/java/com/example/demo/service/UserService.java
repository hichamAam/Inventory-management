package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.api.model.User;

@Service
public class UserService {
    
    private List<User> userList;

    public UserService(){
        userList = new ArrayList<User>();

        User user1 = new User(1, "hicham", 20, "hicham@gmail.com");
        User user2 = new User(2, "hicham", 20, "hicham@gmail.com");
        User user3 = new User(3, "hicham", 20, "hicham@gmail.com");
        User user4 = new User(4, "hicham", 20, "hicham@gmail.com");
        User user5 = new User(5, "hicham", 20, "hicham@gmail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> getUser(Integer id){
        Optional optional = Optional.empty();
        for (User user : userList) {
            if(id == user.getId()){
                optional = Optional.of(user);
            }
        }
        return optional;
    }
}
