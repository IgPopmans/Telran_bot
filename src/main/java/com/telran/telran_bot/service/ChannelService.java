package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;

import java.util.List;


public interface ChannelService {

    List<Channel> getAllChannels();

    Channel createChannel(Channel channel);

    Channel updateChannel(int id ,String name,Channel channel);

    Channel getChannel(int id);

    void deleteChannelById(int id);

}
