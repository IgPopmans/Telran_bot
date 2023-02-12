package com.telran.telran_bot.service;

/**
 * Interface to implement  work with bot commands  has received from the channels and groups
 *
 * @author Igors Popmans
 */

public interface CommandService {
    /**
     * This abstract method for executing start/stop command
     *
     * @param command       bot received from channel/group
     * @param switchableBot specific external identifier of channel/group
     */
    void executeCommand(String command, Switchable switchableBot);
}
