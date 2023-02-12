package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Message;
import com.telran.telran_bot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    /**
     * Field for auto-binding a class with a message repository
     */
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * This method returns the entire list of messages from the database
     *
     * @return list messages from database
     */
    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    /**
     * This method returns a message from the database by id
     *
     * @param messageId message id
     * @return entity message or null from database
     * @throws IllegalArgumentException if entered incorrect internal id
     */
    @Override
    public Optional<Message> getMessage(int messageId) {
        Optional<Message> entity = messageRepository.findById(messageId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Message Not found");
        }
        return entity;
    }

    @Override
    public void createMessage(Message message) {
        messageRepository.save(message);

    }

    /**
     * This method adding message to repository
     *
     * @param title    string title for channel or group
     * @param groupId  external identifier
     * @param text     of message
     * @param userName username
     */
    @Override
    public void createMessage(String title, long groupId, String text, String userName) {
        Message message = new Message(title, groupId, text, userName);
        messageRepository.save(message);
    }


    @Override
    public Message updateMessage(int messageId, String title, int groupId, String text, Message message) {
        Optional<Message> entity = messageRepository.findById(messageId);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("User not Found!");
        }
        message.setId(messageId);
        message.setTitle(title);
        message.setGroupId(groupId);
        message.setText(text);
        return messageRepository.save(message);
    }
    /**
     * This method for deleting message from database by id
     *
     * @param messageId internal id for message
     */
    @Override
    public void deleteMessage(int messageId) {
        messageRepository.deleteById(messageId);
    }

    /**
     * This method return list all new messages from databse
     *
     * @return list new messages from database
     */
    @Override
    public List<Message> listAllNewMessages() {
        return messageRepository.findAllNewMessages();
    }

    /**
     * This method marks read messages like old
     *
     * @return list read messages
     */
    @Override
    public List<Message> getMessagesAndMarkThemOld() {
        List<Message> messages = messageRepository.findAllNewMessages();
        if (!messages.isEmpty()) {
            List<Integer> idsList = messages.stream().map(Message::getId).toList();
            messageRepository.changeIsNewToFalse(idsList);
        }
        return messages;
    }
}
