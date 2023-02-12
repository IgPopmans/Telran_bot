package com.telran.telran_bot.service;

/**
 * This is interface for telegram bot function on/off
 *
 * @author Igors Popmans
 * @version 1.0
 */
public interface Switchable {
    /**
     * This is abstract method for on function
     */
    void on ();
    /**
     * This is abstract method for off function
     */
    void off();

}
