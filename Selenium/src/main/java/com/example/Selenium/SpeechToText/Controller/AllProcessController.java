package com.example.Selenium.SpeechToText.Controller;

import com.example.Selenium.Package02.Selenium;
import com.example.Selenium.SpeechToText.Model.*;
import com.example.Selenium.SpeechToText.View.Response;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.ResponseEntity;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static com.example.Selenium.Package02.ReadFileNameCSV.FileNameCSV;
import static com.example.Selenium.Package02.ReadVoiceCSV.VoiceCSV;

public class AllProcessController {

    public DataStoreModel dataStoreModel;
    CSVStoreModel voiceCSVModel;
    CSVStoreModel fileNameCSVModel;
    CSVStoreModel textCSVModel;
    TelegramDataStoreModel telegramDataStoreModel;
    protected final String columnName1 = "Text";
    protected final String columnName2 = "Voice";
    protected final String columnName3 = "FileName";


    public void work() throws InterruptedException, TelegramApiException {

        textCSVModel = new CSVStoreModel();
        voiceCSVModel = new CSVStoreModel();
        fileNameCSVModel = new CSVStoreModel();

        dataStoreModel = new DataStoreModel();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("1159534870");
        telegramDataStoreModel = new TelegramDataStoreModel("CaptchaSlove_bot", "6928830332:AAGmv3fN_k8YdITzJeOyjqtsDQfWuviF308", sendMessage);

        dataStoreModel.addStatus(EnumController.APPLICATION_STATUS_OK);

        GetDataCSVModel getDataCSVModel = new GetDataCSVModel(voiceCSVModel, fileNameCSVModel, textCSVModel, dataStoreModel);

        getDataCSVModel.getDataFromColumn(columnName1, columnName2, columnName3);

        getDataCSVModel.getNotificationErrorCSV(voiceCSVModel, fileNameCSVModel, dataStoreModel);

        if (dataStoreModel.getStatusEnumSet().contains(EnumController.ERROR_IN_CSV)) {
            Response response = new Response();
            response.SpeechToText(dataStoreModel.getNotification());
        }

        GetChunksToArrayList getChunksToArrayListClass = new GetChunksToArrayList();
        getChunksToArrayListClass.getChunksToArrayList(dataStoreModel.getArrayList_Char(), textCSVModel.getReadTextOfColumn(), dataStoreModel.getLimitChar());

        WebDriver driver1 = null;

        if (textCSVModel.isFlag()) {

            if (dataStoreModel.getArrayList_Char().size() == 1) {
                dataStoreModel.setCountDownLatch(new CountDownLatch(1));

                DataStoreModel dataStoreModelForNewDriver01 = new DataStoreModel();

                LessOrEqual4000CharController lessOrEqual4000CharController = new LessOrEqual4000CharController(dataStoreModel.getCountDownLatch(), telegramDataStoreModel, dataStoreModelForNewDriver01, driver1, dataStoreModel.getArrayList_Char().get(0), textCSVModel, voiceCSVModel, fileNameCSVModel);

                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot(lessOrEqual4000CharController);

                Thread thread01 = new Thread(lessOrEqual4000CharController);
                thread01.start();
                dataStoreModel.getCountDownLatch().await();


            } else if (dataStoreModel.getArrayList_Char().size() >= 2) {
                WebDriver driver2 = null;

                dataStoreModel.setCountDownLatch(new CountDownLatch(2));

                DataStoreModel dataStoreModelForNewDriver01 = new DataStoreModel();
                DataStoreModel dataStoreModelForNewDriver02 = new DataStoreModel();

                LessOrEqual4000CharController lessOrEqual4000CharControllerForThread1 = new LessOrEqual4000CharController(dataStoreModel.getCountDownLatch(), telegramDataStoreModel, dataStoreModelForNewDriver01, driver1, dataStoreModel.getArrayList_Char().get(0), textCSVModel, voiceCSVModel, fileNameCSVModel);
                LessOrEqual4000CharController lessOrEqual4000CharControllerForThread2 = new LessOrEqual4000CharController(dataStoreModel.getCountDownLatch(), telegramDataStoreModel, dataStoreModelForNewDriver02, driver2, dataStoreModel.getArrayList_Char().get(1), textCSVModel, voiceCSVModel, fileNameCSVModel);

                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot(lessOrEqual4000CharControllerForThread1);

                Thread thread01 = new Thread(lessOrEqual4000CharControllerForThread1);
                Thread thread02 = new Thread(lessOrEqual4000CharControllerForThread2);

                thread01.start();
                thread02.start();

                dataStoreModel.getCountDownLatch().await();
            }
        }


        if (!textCSVModel.isFlag()) {
            dataStoreModel.setCountDownLatch(new CountDownLatch(1));

            MoreOrEqual4001CharController moreOrEqual4001CharController = new MoreOrEqual4001CharController(dataStoreModel.getCountDownLatch(), telegramDataStoreModel, dataStoreModel, driver1, dataStoreModel.getArrayList_Char().toString(), textCSVModel, voiceCSVModel, fileNameCSVModel);

            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(moreOrEqual4001CharController);

            Thread thread1 = new Thread(moreOrEqual4001CharController);

            thread1.start();
        }
    }
}

class work123 {
    public static void main(String[] args) throws TelegramApiException {
        AllProcessController allProcessController = new
                AllProcessController();
        try {
            allProcessController.work();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//             TelegramBotsApi telegramBotsApi = null;
//                        try {
//                            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//                            telegramBotsApi.registerBot(lessOrEqual4000CharController);
//                        } catch (TelegramApiException e) {
//                            throw new RuntimeException(e);
//                        }