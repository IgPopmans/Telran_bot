package com.telran.telran_bot.service;

import com.telran.telran_bot.model.User;
import com.telran.telran_bot.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ChannelServiceImpl channelService;

    public UserServiceImpl(UserRepository userRepository, ChannelServiceImpl channelService) {
        this.userRepository = userRepository;
        this.channelService = channelService;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
         return  optionalUser.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteUserById(int id) {
        Optional<User> entity = userRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("User not Found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id, String name, User user) {
        Optional<User> entity = userRepository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("User not Found!");
        }
        user.setId(id);
        user.setName(name);
        return userRepository.save(user);
    }
//
//    public List<User> findAllByName(String name) {
//        return userRepository.findAllByName();
//    }

    private void  getInfoUserChannel(int userId,int channelId) {
        User user = getUserById(userId);
        channelService.getChannel(channelId);
    }
}
