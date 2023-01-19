package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel,Integer> {
}
