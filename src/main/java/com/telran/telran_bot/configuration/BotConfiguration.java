package com.telran.telran_bot.configuration;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import org.telegram.telegrambots.starter.TelegramBotInitializer;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.util.Collections;
import java.util.List;

/**
 * This is class for Telegram bot configuration
 *
 * @author Igors Popmans
 * @version 1.0
 */
@Configuration
public class BotConfiguration {

    /**
     * This method for connection with Telegram bot API
     *
     * @return new Telegram bots API
     * @throws TelegramApiException internal error Telegram
     */

    @Bean
    @ConditionalOnMissingBean(TelegramBotsApi.class)
    public TelegramBotsApi telegramBotsApi() throws TelegramApiException {
        return new TelegramBotsApi(DefaultBotSession.class);
    }

    /**
     * This method for initialization Telegram bot
     *
     * @param telegramBotsApi received API
     * @param longPollingBots long polling bots
     * @param webHookBots     web hook bots
     * @return new initializer bot
     * @see BotConfiguration method for Telegrams bot API
     */

    @Bean
    @ConditionalOnMissingBean
    public TelegramBotInitializer telegramBotInitializer(TelegramBotsApi telegramBotsApi,
                                                         ObjectProvider<List<LongPollingBot>> longPollingBots,
                                                         ObjectProvider<List<SpringWebhookBot>> webHookBots) {
        return new TelegramBotInitializer(telegramBotsApi,
                longPollingBots.getIfAvailable(Collections::emptyList),
                webHookBots.getIfAvailable(Collections::emptyList));
    }
}
