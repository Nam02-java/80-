package com.example.Selenium.SpeechToText.Controller;

import com.example.Selenium.SpeechToText.Model.DataStoreModel;
import com.example.Selenium.SpeechToText.Model.TelegramDataStoreModel;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

public class BotTelegramSetUpController extends TelegramLongPollingBot {

    public TelegramDataStoreModel telegramDataStoreModel;
    public DataStoreModel dataStoreModel;

    public static String messsage;

    public BotTelegramSetUpController(TelegramDataStoreModel telegramDataStoreModel, DataStoreModel dataStoreModel) {
        this.telegramDataStoreModel = telegramDataStoreModel;
        this.dataStoreModel = dataStoreModel;
    }


    @Override
    public void onUpdateReceived(Update update) {
        telegramDataStoreModel.setTextFromUserTelegram(update.getMessage().getText());
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return telegramDataStoreModel.getBotUserName();
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotToken() {
        return telegramDataStoreModel.getBotToken();
    }



}