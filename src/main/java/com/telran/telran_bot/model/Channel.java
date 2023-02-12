package com.telran.telran_bot.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity class Channel,which contains data received from the bot for usage in this program
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
@Table(name = "channel")
public class Channel {

    /**
     * Unique identifier for the Channel,which generated automatically
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Unique Channel id received from bot API
     */
    @NotNull
    @Column()
    private int channelId;

    /**
     * Channel name received from bot API
     */
    @Column(name = "channel_name")
    private String name;

}
