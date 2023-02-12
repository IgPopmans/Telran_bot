package com.telran.telran_bot.service;

import com.telran.telran_bot.model.User;
import com.telran.telran_bot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * This class to implement the business logic of user_service entity
 *
 * @author Igors Popmans
 * @version 1.0
 * @see UserService
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Field for auto-binding a class with a user repository
     */
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    /**
     * This method returns  list of users from the database
     *
     * @return list all users from database
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method for creating a new user entity
     *
     * @param user user entity
     * @return new user entity to repository
     * @throws IllegalArgumentException if fields for user entity filled out incorrectly
     */
    @Override
    public User saveUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
        return user;
    }

    /**
     * This method for getting a user entity from database by id
     *
     * @param id user entity from database
     * @return user entity
     * @throws IllegalArgumentException if user id from repository incorrect
     */
    @Override
    public User getUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(EntityNotFoundException::new);
    }

    /**
     * This method for deleting a user from repository by id
     *
     * @param id user internal id
     * @throws IllegalArgumentException if entered incorrect id for user
     */
    @Override
    public void deleteUserById(int id) {
        Optional<User> entity = userRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("User not Found");
        }
        userRepository.deleteById(id);
    }

    /**
     * This method for updating a user entity from repository
     *
     * @param id,name,user user entity from database
     * @return updated user entity
     * @throws IllegalArgumentException if user id from database incorrect
     */
    @Override
    public User updateUser(int id, String name, User user) {
        Optional<User> entity = userRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("User not Found!");
        }
        user.setId(id);
        user.setName(name);
        return userRepository.save(user);
    }
}
