package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.model.UserChannel;
import com.telran.telran_bot.repository.ChannelRepository;
import com.telran.telran_bot.repository.UserChannelRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserChannelServiceImpl implements UserChannelService {

    private final UserChannelRepository userChannelRepository;
    private final ChannelRepository channelRepository;

    public UserChannelServiceImpl(UserChannelRepository userChannelRepository, ChannelRepository channelRepository) {
        this.userChannelRepository = userChannelRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public Optional<UserChannel> getAllUserChannels(int userId) {
        Optional<UserChannel> entity = userChannelRepository.findById(userId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Not found");
        }
        return entity;

    }

    @Override
    public void addUserSubscription(int userId, Channel channel) {
        userChannelRepository.save(new UserChannel(userId, channel.getId()));

    }
//
//    @Override
//    public void deleteUserSubscription(int userId, Channel channel) {
//        UserChannel userChannelByUserId = userChannelRepository.findUserChannelByUserId(userId);
//        userChannelRepository.delete(userChannelByUserId);
//
//    }

}
