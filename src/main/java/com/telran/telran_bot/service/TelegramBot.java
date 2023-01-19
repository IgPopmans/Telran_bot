package com.telran.telran_bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Telranpro_bot";
    }

    @Override
    public String getBotToken() {
        return "5807478975:AAFgKOAh-vi2qujfz4_TkjveDp5H8ZDmjEg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        Chat chat = message.getChat();
        if (chat.isGroupChat()) {
            String title = chat.getTitle();
            Long chatId = message.getChatId();
            String text = message.getText();
        }

    }
}
