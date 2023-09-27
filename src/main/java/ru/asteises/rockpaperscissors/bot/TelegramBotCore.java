package ru.asteises.rockpaperscissors.bot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.asteises.rockpaperscissors.bot.commands.StartCommand;

public class TelegramBotCore extends TelegramLongPollingCommandBot {

    private final String botUsername;
    private final String botToken;

    public TelegramBotCore(String botUsername, String botToken) {
        super(botToken);
        register(new StartCommand("start", "Start command"));
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }


}
