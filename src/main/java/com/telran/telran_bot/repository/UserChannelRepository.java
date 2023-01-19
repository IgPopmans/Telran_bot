package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChannelRepository extends JpaRepository<UserChannel,Integer> {

//    UserChannel findUserChannelByUserId(int userId);
}
