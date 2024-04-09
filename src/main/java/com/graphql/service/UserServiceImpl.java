package com.graphql.service;

import com.graphql.model.User;
import com.graphql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int userID) {
        return userRepo.findById(userID).orElseThrow(()->new RuntimeException("User not found!"));
    }

    @Override
    public User updateUser(User user,int userID) {
        User user1=userRepo.findById(userID).orElseThrow(()->new RuntimeException("User not found!"));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setMobile(user.getMobile());
        return userRepo.save(user1);
    }

    @Override
    public boolean deleteUser(int userID) {
        User user=userRepo.findById(userID).orElseThrow(()->new RuntimeException("User not found!"));
        userRepo.delete(user);
        return true;
    }
}
