package com.telran.telran_bot.model;

import lombok.*;
import javax.persistence.*;

/**
 * This entity class, that's create users with roles to receive events from channel of group telegram
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
@Table(name = "tel_user")
public class User {

    /**
     * Unique identifier for the user,which generated automatically
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * This is field to define the username
     */
    @Column(name = "user_name")
    private String name;

}
