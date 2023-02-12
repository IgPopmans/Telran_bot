package com.telran.telran_bot.controller;


import com.telran.telran_bot.model.Channel;
import com.telran.telran_bot.model.UserChannel;
import com.telran.telran_bot.service.UserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user_channels/{userid}")
public class UserChannelController {

    private final UserChannelService userChannelService;

    @Autowired
    public UserChannelController(UserChannelService userChannelService) {
        this.userChannelService = userChannelService;
    }

    @GetMapping
    public ResponseEntity<List<UserChannel>> getAllChannels(@PathVariable(name = "userid") int userId) {
        try {
            List<UserChannel> allUserChannels = userChannelService.getAllUserChannels(userId);
            return new ResponseEntity<>(allUserChannels, HttpStatus.OK);

        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public void addUserSubscription(@PathVariable(name = "userid") int userId, @RequestBody Channel channel) {
        userChannelService.addUserSubscription(userId, channel);
    }


    @DeleteMapping()
    public ResponseEntity<?> deleteUserSubscription(@PathVariable("userid")int userid,@RequestBody Channel channel) {
        try {
            userChannelService.deleteUserSubscription(userid,channel);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
