package com.telran.telran_bot.service;

import com.telran.telran_bot.model.TelegramMessage;
import com.telran.telran_bot.model.User;
import com.telran.telran_bot.repository.TelegramMessageRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TelegramMessageServiceImpl implements TelegramMessageService {

    private final TelegramMessageRepository telegramMessageRepository;

    public TelegramMessageServiceImpl(TelegramMessageRepository telegramMessageRepository) {
        this.telegramMessageRepository = telegramMessageRepository;
    }

    @Override
    public List<TelegramMessage> getAllMessages() {
        return telegramMessageRepository.findAll();
    }

    @Override
    public Optional<TelegramMessage> getMessage(int messageId) {
        Optional<TelegramMessage> entity = telegramMessageRepository.findById(messageId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Message Not found");
        }
        return entity;

    }

    @Override
    public void createMessage(TelegramMessage message) {
        telegramMessageRepository.save(message);

    }

    @Override
    public TelegramMessage updateMessage(int messageId, String title, long groupId, String text, TelegramMessage telegramMessage) {
        Optional<TelegramMessage> entity = telegramMessageRepository.findById(messageId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("User not Found!");
        }
        telegramMessage.setId(messageId);
        telegramMessage.setTitle(title);
        telegramMessage.setGroupId(groupId);
        telegramMessage.setText(text);
        return telegramMessageRepository.save(telegramMessage);
    }

    @Override
    public void deleteMessage(int messageId) {
        telegramMessageRepository.deleteById(messageId);

    }
}
