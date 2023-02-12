package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Message;

import java.util.List;
import java.util.Optional;

/**
 * This is interface for abstracting business logic for the message entity
 *
 * @author Igors Popmans
 * @version 1.0
 */

public interface MessageService {
    /**
     * This abstract method for return list all messages from database
     *
     * @return all messages from database
     */
    List<Message> getAllMessages();

    /**
     * This abstract method for return message from database
     *
     * @param messageId message id
     * @return entity message from repository
     */
    Optional<Message> getMessage(int messageId);

    /**
     * This abstract method for adding message to database
     *
     * @param message entity
     */
    void createMessage(Message message);

    /**
     * This abstract method for adding message to database
     *
     * @param title    string title for channel or group
     * @param groupId  external identifier
     * @param text     of message
     * @param userName username
     */
    void createMessage(String title, long groupId, String text, String userName);

    /**
     * This abstract method for updating message in database
     *
     * @param title   string title for channel or group
     * @param groupId external identifier
     * @param text    of message
     * @param message Message
     */
    Message updateMessage(int messageId, String title, int groupId, String text, Message message);

    /**
     * This abstract method for deleting message from database by internal id
     *
     * @param messageId internal id for message
     */
    void deleteMessage(int messageId);

    List<Message> listAllNewMessages();

    /**
     * This abstract method marks read messages like old
     *
     * @return list all read messages
     */
    List<Message> getMessagesAndMarkThemOld();
}
