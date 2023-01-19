package com.telran.telran_bot.service;

import com.telran.telran_bot.model.TelegramMessage;

import java.util.List;
import java.util.Optional;

public interface TelegramMessageService {

    List<TelegramMessage> getAllMessages();

    Optional<TelegramMessage> getMessage(int messageId);

    void createMessage(TelegramMessage message);

    TelegramMessage updateMessage(int messageId,String title,long groupId,String text,TelegramMessage telegramMessage);

    void deleteMessage(int messageId);

}
