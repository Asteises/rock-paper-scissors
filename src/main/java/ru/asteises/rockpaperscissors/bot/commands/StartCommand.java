package ru.asteises.rockpaperscissors.bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.asteises.rockpaperscissors.bot.keyboards.DefaultKeyboard;

public class StartCommand extends ServiceCommand {

    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false);
        sendMessage.setChatId(chat.getId());
        sendMessage.setText("Добро пожаловать, " + user.getUserName() + " ! Сыграем в камень-ножницы-бумага?");

        try {
            absSender.execute(sendMessage);
            absSender.execute(DefaultKeyboard.getDefaultKeyboard(chat.getId()));
        } catch (TelegramApiException e) {
            throw new RuntimeException("ТЕКСТ ИСКЛЮЧЕНИЯ");
        }
    }
}
