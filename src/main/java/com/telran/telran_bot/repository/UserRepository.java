package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * This is interface for storage user in database
 *
 * @author Igors Popmans
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

    /**
     * This method is to check if user exists in database
     *
     * @param id internal identifier for user
     * @return true or false if user exists
     */
    boolean existsById(int id);
}
