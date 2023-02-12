package com.telran.telran_bot.service;


import com.telran.telran_bot.model.*;
import com.telran.telran_bot.repository.EventRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * This class to implement the business logic of event entity
 *
 * @author Igors Popmans
 * @version 1.0
 * @see EventService
 */
@Service
public class EventServiceImpl implements EventService {

    /**
     * Fields for auto-binding
     */
    private final UserService userService;
    private final UserChannelService userChannelService;
    private final MessageService messageService;
    private final ChannelService channelService;
    private final EventRepository eventRepository;

    public EventServiceImpl(UserService userService, UserChannelService userChannelService, MessageService messageService, ChannelService channelService, EventRepository eventRepository) {
        this.userService = userService;
        this.userChannelService = userChannelService;
        this.messageService = messageService;
        this.channelService = channelService;
        this.eventRepository = eventRepository;
    }

    /**
     * This is a method for creating an event that runs at a time specified in application properties according to a schedule
     */
    @Override
    @Scheduled(fixedRateString = "${method.schedule}")
    public void createNewEvents() {


        List<Message> messages = messageService.getMessagesAndMarkThemOld();
        if (messages.isEmpty()) return;

        List<Long> uniqueChannelIdsFromMessages = messages.stream().map(Message::getGroupId).distinct().toList();
        List<Integer> channelIds = channelService.findAllIdsByChannelIdFromUniqueChannelIdsList(uniqueChannelIdsFromMessages);
        List<UserChannel> allUserChannelsByChannelIdFromIdsList = userChannelService
                .findAllUserChannelsByChannelIdFromIdsList(channelIds);
        String text = "Hello,you got a Message";
        allUserChannelsByChannelIdFromIdsList.forEach(userChannel -> createEvent(new Event(userChannel.getUserId(), userChannel.getChannelId(), text)));
    }

    /**
     * This method for getting new events by user id
     *
     * @param userId user id
     * @return from event repository all new saved event by user id
     * @throws IllegalArgumentException if user id not exist in database
     */
    @Override
    public List<Event> getNewEventsByUser(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Please enter correct ID for user");
        }
        List<Event> allNewEventsByUserId = eventRepository.findAllByUserId(userId);
        allNewEventsByUserId.forEach(ev -> ev.setNew(false));
        return eventRepository.saveAll(allNewEventsByUserId);
    }

    /**
     * This method for creating a new entity event
     *
     * @param event entity event
     * @return saved entity event in database
     */
    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    /**
     * This method for find all events by user id
     *
     * @param userId user id
     * @return list events by user id from database
     * @throws IllegalArgumentException if user id not exist in database
     */
    @Override
    public List<Event> findAllByUserId(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Here is a wrong id");
        }
        return eventRepository.findAllByUserId(userId);
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    /**
     * This method for deleting an event from database by id
     *
     * @param id exist entity event
     * @throws IllegalArgumentException if entity event with this id in database not exist
     */
    @Override
    public void deleteEvent(int id) {
        if (eventRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Here is wrong id,please enter correct id");
        }
        eventRepository.delete(getEvent(id));
    }
}
