package com.graphql.service;


import com.graphql.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(int userID);
    User updateUser(User user,int userID);
    boolean deleteUser(int userId);
}
