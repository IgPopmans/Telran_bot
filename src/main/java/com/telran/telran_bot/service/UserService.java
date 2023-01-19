package com.telran.telran_bot.service;

import com.telran.telran_bot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);

    User updateUser(int id,String name,User user);

    //  public List<User> findAllByName(String name);

}
