package com.telran.telran_bot.controller;


import com.telran.telran_bot.model.Event;
import com.telran.telran_bot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{user_id}")
    public List<Event> getNewEventByUserId(@PathVariable(name = "user_id") int id) {
        try {
            return eventService.getNewEventsByUser(id);
        } catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String removeEvent(@PathVariable(name = "id") int id) {
        try {
            eventService.deleteEvent(id);
            return "Event " + id + " is removed";
        } catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}