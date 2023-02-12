package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
/**
 * This class to implement the business logic of channel entity
 *
 * @author Igors Popmans
 * @version 1.0
 * @see ChannelService
*/
@Service
public class ChannelServiceImpl implements ChannelService {

    /**
     * Field for auto-binding a class with a channel repository
     */
    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    /**
     * This method returns the channel entity from the repository
     *
     * @param id
     * @return  channel entity
     */
    @Override
    public Channel getChannel(int id) {
        Optional<Channel> entity = channelRepository.findById(id);
        return entity.orElseThrow(EntityNotFoundException::new);
    }

    /**
     * This method returns the  list of channels from the repository
     *
     * @return list of channels
     */
    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    /**
     * This method for creating a new entity channel
     *
     * @param channel entity channel
     * @return saved channel in repository
     * @throws IllegalArgumentException if entered incorrect data for fields
     */
    @Override
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    /**
     * This method for updating a channel entity from repository
     *
     * @param channel,id,name entity channel
     * @return updated channel
     * @throws IllegalArgumentException if entered incorrect id for channel
     */
    @Override
    public Channel updateChannel(int id, String name, Channel channel) {
        Optional<Channel> entity = channelRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Channel not found");
        }
        channel.setId(id);
        channel.setName(name);
       return channelRepository.save(channel);
    }
    /**
     * This method for deleting a channel from repository by id
     *
     * @param id channel id
     * @throws IllegalArgumentException if in repository not exist entity channel with entered id
     */
    @Override
    public void deleteChannelById(int id) {
        Optional<Channel> entity = channelRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Channel not found");
        }
        channelRepository.deleteById(id);
    }

    /**
     * This method for finding all ids by channel ids from unique channel ids list
     *
     * @param channelIds list channel ids
     * @return all ids by channel ids from unique channel ids list
     */
    @Override
    public List<Integer> findAllIdsByChannelIdFromUniqueChannelIdsList(List<Long> channelIds) {
        return channelRepository.findAllIdsByChannelIdFromUniqueChannelIdsList(channelIds);
    }


    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}
