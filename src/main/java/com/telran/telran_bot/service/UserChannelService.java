package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.model.UserChannel;
import java.util.List;

/**
 * This is interface for abstracting business logic for the user_channel entity
 *
 * @author Igors Popmans
 * @version 1.0
 */
public interface UserChannelService {
    /**
     * This abstract method for return list all user_channels by id
     *
     * @return list user_channels from database
     */
    List<UserChannel> getAllUserChannels(int userId);

    /**
     * This abstract method for return list all user_channels
     *
     * @return list user_channels from database
     */
    List<UserChannel>getAllUserChannels();

    /**
     * This abstract method for subscribe a user to a channel
     *
     * @param userId    entity user
     * @param channel entity channel
     */
    void addUserSubscription(int userId, Channel channel);

    /**
     * This abstract method for deleting subscribe user  channel
     *
     * @param userId    entity user
     * @param channel entity channel
     */
    void deleteUserSubscription(int userId, Channel channel);

    List<Integer> findAllUsersByChannelId(int channelId);

    /**
     * This abstract method for find all user_channels by channel ids from ids list
     *
     * @param channelIds channel ids list
     * @return list user_channel
     */
    List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(List<Integer> channelIds);
}
