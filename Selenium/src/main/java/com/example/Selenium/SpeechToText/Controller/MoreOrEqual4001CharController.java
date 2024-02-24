package com.example.Selenium.SpeechToText.Controller;

import com.example.Selenium.SpeechToText.Model.CSVStoreModel;
import com.example.Selenium.SpeechToText.Model.DataStoreModel;
import com.example.Selenium.SpeechToText.Model.TelegramDataStoreModel;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.CountDownLatch;

public class MoreOrEqual4001CharController extends InitializationDriverController {
    public MoreOrEqual4001CharController(CountDownLatch countDownLatch, TelegramDataStoreModel telegramDataStoreModel, DataStoreModel dataStoreModel, WebDriver driver, String textFromTextColumnCsvFile, CSVStoreModel textCsvStoreModel, CSVStoreModel voiceCsvStoreModel, CSVStoreModel fileNameCsvStoreModel) {
        super(telegramDataStoreModel, dataStoreModel, driver, textFromTextColumnCsvFile, textCsvStoreModel, voiceCsvStoreModel, fileNameCsvStoreModel);
        this.dataStoreModel.countDownLatch = countDownLatch;
    }
}
