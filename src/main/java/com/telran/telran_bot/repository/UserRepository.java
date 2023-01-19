package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User,Integer> {

//    List<User>findAllByName();
}
