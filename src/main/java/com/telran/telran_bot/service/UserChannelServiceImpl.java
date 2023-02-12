package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.model.UserChannel;
import com.telran.telran_bot.repository.UserChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * This class to implement the business logic of use_channel entity
 *
 * @author Igors Popmans
 * @version 1.0
 * @see UserChannelService
 */
@Service
public class UserChannelServiceImpl implements UserChannelService {

    /**
     * Field for auto-binding a class with a user_channel repository
     */
    private final UserChannelRepository userChannelRepository;

    @Autowired
    public UserChannelServiceImpl(UserChannelRepository userChannelRepository) {
        this.userChannelRepository = userChannelRepository;
    }

    @Override
    public List<UserChannel> getAllUserChannels(int userId) {
        List<UserChannel> entity = userChannelRepository.findByUserId(userId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("UserChannel not found");
        }
        return entity;
    }

    /**
     * This method returns the entire list of user_channels from the database
     *
     * @return list user_channels entities from database
     */
    @Override
    public List<UserChannel> getAllUserChannels() {
        return userChannelRepository.findAll();
    }

    /**
     * This method to subscribe the user to the channel
     *
     * @param userId  entity user
     * @param channel entity channel
     * @throws IllegalArgumentException if user or channel internal ids incorrect
     */
    @Override
    public void addUserSubscription(int userId, Channel channel) {
        userChannelRepository.save(new UserChannel(userId, channel.getChannelId()));

    }

    /**
     * This method to  delete subscribe  user to the channel
     *
     * @param userId  entity user
     * @param channel entity channel
     * @throws IllegalArgumentException if user or channel internal ids incorrect
     */
    @Override
    public void deleteUserSubscription(int userId, Channel channel) {
        UserChannel userChannel = userChannelRepository.findByUserIdAndChannelId(userId, channel.getChannelId());
        userChannelRepository.delete(userChannel);
    }

    /**
     * This method for find all channels by channel id
     *
     * @param channelId entity user
     * @return list channels by id
     * @throws IllegalArgumentException if id is incorrect
     */
    @Override
    public List<Integer> findAllUsersByChannelId(int channelId) {
        return userChannelRepository.findAllUserIdByChannelId(channelId);
    }

    /**
     * This method for find all user_channels by channel ids from ids list
     *
     * @param channelIds channel ids list
     * @return all user_channels from repository
     */
    @Override
    public List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(List<Integer> channelIds) {
        return userChannelRepository.findAllUserChannelsByChannelIdFromIdsList(channelIds);
    }
}
