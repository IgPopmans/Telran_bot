package com.telran.telran_bot.service;

import com.telran.telran_bot.commands.Command;
import org.springframework.stereotype.Service;

/**
 * This class to implement the business logic from the interface Command for bots start stop function
 *
 * @author Igors Popmans
 * @version 1.0
 * @see CommandService
 */

@Service
public class CommandServiceImpl implements CommandService {

    /**
     * This method implements the passed command start or stop
     *
     * @param command       string command and interface Switchable with variable switchable-bot
     * @param switchableBot variable for interface Switchable and string command
     */
    @Override
    public void executeCommand(String command,Switchable switchableBot) {
        if (Command.START.getName().equals(command)) {
            switchableBot.on();
        } else if (Command.STOP.getName().equals(command)) {
            switchableBot.off();
        }
    }
}
