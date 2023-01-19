package com.telran.telran_bot.repository;

import com.telran.telran_bot.model.TelegramMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramMessageRepository extends JpaRepository<TelegramMessage,Integer> {

}
