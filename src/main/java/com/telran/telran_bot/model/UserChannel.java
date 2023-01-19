package com.telran.telran_bot.model;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_channel")
public class UserChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int UserId;

    @Column(name = "channel_id")
    private int channelId;

    boolean isActive;

    public UserChannel(int userId, int id) {

    }
}
