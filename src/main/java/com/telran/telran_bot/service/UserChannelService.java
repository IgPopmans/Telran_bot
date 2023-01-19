package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.model.UserChannel;

import java.util.Optional;

public interface UserChannelService {

    Optional<UserChannel> getAllUserChannels(int userId);

    void addUserSubscription(int userId, Channel channel);

//    void deleteUserSubscription(int userId,Channel channel);


}
