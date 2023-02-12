package com.telran.telran_bot.service;

import com.telran.telran_bot.model.User;
import java.util.List;

/**
 * This is interface for abstracting business logic for the user entity
 *
 * @author Igors Popmans
 * @version 1.0
 */

public interface UserService {

    /**
     * This abstract method for return list all users
     *
     * @return list all users from database
     */
    List<User> getAllUsers();

    /**
     * This abstract method for creating a new user entity
     *
     * @param user user entity
     * @return new user entity
     */
    User saveUser(User user);

    /**
     * This abstract method to find  user by id from database
     *
     * @param id user entity from database
     * @return updated user entity
     */
    User getUserById(int id);

    /**
     * This abstract method for deleting user by id from database
     *
     * @param id user entity from database
     */
    void deleteUserById(int id);

    /**
     * This abstract method for updating user entity
     *
     * @param user user entity from database
     * @return updated user entity
     */
    User updateUser(int id, String name, User user);


}
