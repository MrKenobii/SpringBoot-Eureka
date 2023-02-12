package com.kenobi.userservice.services;


import com.kenobi.userservice.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getUsers();
    User getUser(String userId);



}
