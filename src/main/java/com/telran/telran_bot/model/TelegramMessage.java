package com.telran.telran_bot.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "telegram_message")
public class TelegramMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name")
    private String title;

    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "message")
    private String text;

    private boolean isNew = true;
}
