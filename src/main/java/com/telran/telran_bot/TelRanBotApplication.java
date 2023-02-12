package com.telran.telran_bot;

import com.telran.telran_bot.configuration.BotConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * This is main class for running the program
 *
 * @author Igors Popmans
 * @version 1.0
 */

@SpringBootApplication
@Import(BotConfiguration.class)
@EnableScheduling
public class TelRanBotApplication {

    /**
     * This is method main,where start point of the program
     *
     * @param args command line values
     */
    public static void main(String[] args) {
        SpringApplication.run(TelRanBotApplication.class, args);
    }

}
