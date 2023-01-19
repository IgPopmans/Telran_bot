package com.telran.telran_bot.controller;


import com.telran.telran_bot.model.UserChannel;
import com.telran.telran_bot.service.UserChannelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/userchannels/{userid}")
public class UserChannelController {

    private final UserChannelService userChannelService;

    public UserChannelController(UserChannelService userChannelService) {
        this.userChannelService = userChannelService;
    }
    @GetMapping
    public Optional<UserChannel> getAllChannels(@PathVariable(name = "userId") int userId) {
        return userChannelService.getAllUserChannels(userId);
    }

    //todo


}
