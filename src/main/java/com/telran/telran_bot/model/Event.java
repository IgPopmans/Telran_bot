package com.telran.telran_bot.model;

import lombok.*;
import javax.persistence.*;

/**
 * Entity class of the event , which  create new messages for the user
 *
 * @author Igors Popmans
 * @version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "event")
public class Event {

    /**
     * Unique identifier for the event,which generated automatically
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_for_user_channel")
    private String eventForUserChannel;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "channel_id")
    private long channelId;

    /**
     * This field is for changing the state of our events from new to old
     */
    @Column(name = "is_new")
    private boolean isNew = true;

    public Event(String eventForUserChannel, int userId, long channelId) {
        this.eventForUserChannel = eventForUserChannel;
        this.userId = userId;
        this.channelId = channelId;
    }

    public Event(long userId, long channelId, String text) {
        //
    }
}
