package com.telran.telran_bot.model;

import lombok.*;
import javax.persistence.*;

/**
 * Entity class  where we receive messages  from the Telegram
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
@Table(name = "message")
public class Message {

    /**
     * Unique identifier for the message,which generated automatically
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message_id")
    private int messageId;

    /**
     * Title for group-name  received from telegram-bot
     */
    @Column(name = "group_name")
    private String title;

    /**
     * Unique group id received from telegram- bot
     */
    @Column(name = "group_id")
    private long groupId;

    @Column(name = "message")
    private String text;

    /**
     * User-name for User received from telegram-bot
     */
    @Column(name = "user_name")
    private String userName;

    /**
     *  Field to switch if the message is old or new
     */
    @Column(name = "is_new")
    private boolean isNew;

    public Message(String title, long groupId, String text, String userName) {
        this.title = title;
        this.groupId = groupId;
        this.text = text;
        this.userName = userName;
    }
}
