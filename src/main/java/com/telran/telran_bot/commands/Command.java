package com.telran.telran_bot.commands;

/**
 * This is  class enum with name Command, to activate bot start/stop function
 *
 * @author Igors Popmans
 * @version 1.0
 */
public enum Command {
    /**
     * Enum fields initialization
     */
    START("/start"),
    STOP("/stop");
    /**
     * String field for  enum fields name
     */
    private String name;

    public String getName() {
        return name;
    }

    Command(String name) {
        this.name = name;
    }
}
