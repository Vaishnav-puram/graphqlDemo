package com.graphql.controller;

import com.graphql.model.User;
import com.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument String name,@Argument String email,@Argument String password,@Argument String mobile){
        User user=new User();
        user.setName(name);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @QueryMapping
    public User getUserById(@Argument int userID){
        return userService.getUserById(userID);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userID){
        return userService.deleteUser(userID);
    }

}
