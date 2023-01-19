package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.repository.ChannelRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel getChannel(int id) {
        Optional<Channel> entity = channelRepository.findById(id);
        return entity.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

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
    @Override
    public void deleteChannelById(int id) {
        Optional<Channel> entity = channelRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Channel not found");
        }
        channelRepository.deleteById(id);
    }
}
