package com.telran.telran_bot.controller;

import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.service.ChannelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping()
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Channel> getChannel(@PathVariable("id") int id) {
        try {
            Channel channel = channelService.getChannel(id);
            return new ResponseEntity<>(channel, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        Channel createdEntity = channelService.createChannel(channel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdEntity.getId()).toUri();
        return ResponseEntity.created(location).body(createdEntity);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Channel> update(@PathVariable("id") int id, @RequestBody Channel channel) {
        try {
            Channel updatedChannel = channelService.updateChannel(id, channel.getName(), channel);
            return new ResponseEntity<>(updatedChannel, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            channelService.deleteChannelById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
