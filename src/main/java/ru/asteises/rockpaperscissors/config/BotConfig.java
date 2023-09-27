package ru.asteises.rockpaperscissors.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.asteises.rockpaperscissors.bot.TelegramBotCore;

@Configuration
public class BotConfig {

    @Bean
    public TelegramBotCore botCore(@Value("${telegram.bot.name}") String botName,
                                   @Value("${telegram.bot.token}") String botToken) {
        return new TelegramBotCore(
                botName,
                botToken);
    }

    @Bean
    public TelegramBotsApi botsApi(TelegramBotCore botCore) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(botCore);
        return telegramBotsApi;
    }
}
