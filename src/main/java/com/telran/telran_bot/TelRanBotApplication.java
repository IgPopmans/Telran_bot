package com.telran.telran_bot;

import com.telran.telran_bot.configuration.BotConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BotConfiguration.class)
public class TelRanBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelRanBotApplication.class, args);
    }

}
