package com.telran.telran_bot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * This class to receive data from telegram and initialize telegram bot which is inherited from the class TelegramLongPollingBot
 *
 * @author Igors Popmans
 * @version 1.0
 * @see TelegramLongPollingBot
 */
@Service
@PropertySource("bot.properties")
public class TelegramBot extends TelegramLongPollingBot implements Switchable {
    /**
     * This field for bot name the value in application properties
     */
    @Value("${bot.name}")
    private String botName;
    /**
     * This field for bot name the value in application properties
     */
    @Value(("${bot.token}"))
    private String botToken;

    /**
     * This field enables or disables the bot,by default the bot is active
     */
    private boolean enabled = true;

    /**
     * Fields for auto-binding
     */
    private MessageService messageService;
    private CommandService commandService;

    @Autowired
    public TelegramBot(MessageService messageService, CommandService commandService) {
        this.messageService = messageService;
        this.commandService = commandService;
    }

    public TelegramBot() {
        //
    }

    /**
     * This is built-in method for telegram bot where we receive and save data for a chat or message
     *
     * @param update object type update
     * @see Update
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().isCommand()) {
            commandService.executeCommand(update.getMessage().getText(), this);
            return;
        }
        if (!enabled) {
            return;
        }
        Message message = update.getMessage();
        Chat chat = message.getChat();
        if (chat.isGroupChat() || chat.isSuperGroupChat()) {
            String title = chat.getTitle();
            Long groupId = message.getChatId();
            String text = message.getText();
            String userName = message.getFrom().getUserName();
            messageService.createMessage(title, groupId, text, userName);
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    /**
     * This method will activate telegram bot
     */
    @Override
    public void on() {
        enabled = true;
    }
    /**
     * This method will deactivate telegram bot
     */
    @Override
    public void off() {
        enabled = false;
    }
}

