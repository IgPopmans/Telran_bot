package com.telran.telran_bot.service;

import com.telran.telran_bot.model.Event;

import java.util.List;

/**
 * This is interface for abstracting business logic for the event entity
 *
 * @author Igors Popmans
 * @version 1.0
 */
public interface EventService {

    void createNewEvents();

    /**
     * This abstract method for getting new entity events from database by user id
     *
     * @param userId exist entity event
     */
    List<Event> getNewEventsByUser(int userId);


    /**
     * This abstract method for creating entity event in database
     *
     * @param event exist entity event
     */
    void createEvent(Event event);

    /**
     * This abstract method for finding all event entity's  from database by user id
     *
     * @param userId exist entity event
     */
    List<Event> findAllByUserId(int userId);

    /**
     * This abstract method for return event from database by id
     *
     * @param id int event id
     * @return event by id
     */
    Event getEvent(int id);

    /**
     * This abstract method for deleting entity event from database
     *
     * @param id exist entity event
     */
    void deleteEvent(int id);
}
