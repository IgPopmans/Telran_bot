package com.telran.telran_bot.model;


import lombok.*;
import javax.persistence.*;

/**
 * This is an Entity class created for the  user and channel to indicate, which channels the user is subscribed to
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
@Table(name = "user_channel")
public class UserChannel {

    /**
     * Unique identifier for the user_channel,which generated automatically
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * This is ID for user
     */
    @Column(name = "user_id")
    private long userId;

    /**
     * This is ID for channel
     */
    @Column(name = "channel_id")
    private long channelId;


    public UserChannel(int userId, long channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }
}
