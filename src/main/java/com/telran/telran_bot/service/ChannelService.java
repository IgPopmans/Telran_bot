package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;

import java.util.List;

/**
 * This is interface for abstracting business logic for the channel entity
 *
 * @author Igors Popmans
 * @version 1.0
 */
public interface ChannelService extends Switchable {

    /**
     * This abstract method for return list all channels
     *
     * @return list all channels
     */
    List<Channel> getAllChannels();

    /**
     * This abstract method for creating a new channel entity
     *
     * @param channel entity channel
     * @return new channel
     */
    Channel createChannel(Channel channel);

    /**
     * This abstract method for updating channel entity
     *
     * @param channel channel from database
     * @return updating channel
     */
    Channel updateChannel(int id, String name, Channel channel);

    /**
     * This abstract method for getting channel entity
     *
     * @param id channel from database
     * @return updating channel
     */
    Channel getChannel(int id);

    /**
     * This abstract method for deleting channel entity by id
     *
     * @param id channel from database
     * @return updating channel
     */
    void deleteChannelById(int id);

    /**
     * This abstract method for find all ids by channel id from unique channel ids list
     *
     * @param channelIds list channel ids
     * @return list long ids
     */
    List<Integer> findAllIdsByChannelIdFromUniqueChannelIdsList(List<Long> channelIds);
}
