package ru.asteises.rockpaperscissors.bot.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class DefaultKeyboard {

    public static SendMessage getDefaultKeyboard(long chatId) {
        String id = String.valueOf(chatId);
        SendMessage sendMessage = new SendMessage(id, "ТЕКСТ ДЛЯ СООБЩЕНИЯ");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyBoard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton exchangeInfo = new InlineKeyboardButton();
        exchangeInfo.setText("ТЕКСТ ДЛЯ КНОПКИ");;
        exchangeInfo.setCallbackData("CALLBACK DATA");

        row.add(exchangeInfo);
        keyBoard.add(row);
        markup.setKeyboard(keyBoard);
        sendMessage.setReplyMarkup(markup);

        return sendMessage;
    }
}
