package com.example.Selenium.SpeechToText.Model;

import com.example.Selenium.SpeechToText.Controller.EnumController;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class DataStoreModel {
    private EnumSet<EnumController> statusEnumSet = EnumSet.noneOf(EnumController.class);

    public String userName = "nam03test";
    public String userPassWord = "IUtrangmaimai02";
    public String text, textConstructor, notification = null;
    public CountDownLatch countDownLatch;
    private String countDownLatchName;
    public final int limitChar = 2000;
    public ArrayList<String> arrayList_Char = new ArrayList<>();

    public Map<String, String> params;
    public String DownloadsFilePath = "E:\\New folder\\";
    public String ImageCaptchaFilePath = "E:\\CongViecHocTap\\Captcha\\";
    public WebElement webElement;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor javascriptExecutor;
    public List<WebElement> element_solve;
    public WebDriver driver;
    public ChromeOptions chromeOptions;
    public boolean flag;


    public DataStoreModel(int count, String countDownLatchName) {
        this.countDownLatch = new CountDownLatch(count);
        this.countDownLatchName = countDownLatchName;
    }

    public void await() throws InterruptedException {
        countDownLatch.await();
    }

    public void countDown() {
        countDownLatch.countDown();
    }

    public void setTextConstructor(String textConstructor) {
        this.textConstructor = textConstructor;
    }

    public String getCountDownLatchName() {
        return countDownLatchName;
    }

    public void setCountDownLatchName(String countDownLatchName) {
        this.countDownLatchName = countDownLatchName;
    }

    public String getImageCaptchaFilePath() {
        return ImageCaptchaFilePath;
    }

    public void setImageCaptchaFilePath(String imageCaptchaFilePath) {
        ImageCaptchaFilePath = imageCaptchaFilePath;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setStatusEnumSet(EnumSet<EnumController> statusEnumSet) {
        this.statusEnumSet = statusEnumSet;
    }

    public ChromeOptions getChromeOptions() {
        return chromeOptions;
    }

    public void setChromeOptions(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

    public DataStoreModel() {
    }

    public EnumSet<EnumController> getStatusEnumSet() {
        return statusEnumSet;
    }

    public void addStatus(EnumController status) {
        statusEnumSet.add(status);
    }

    public void removeStatus(EnumController status) {
        statusEnumSet.remove(status);
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void setWebDriverWait(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor;
    }

    public void setJavascriptExecutor(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public List<WebElement> getElement_solve() {
        return element_solve;
    }

    public void setElement_solve(List<WebElement> element_solve) {
        this.element_solve = element_solve;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextConstructor() {
        return textConstructor;
    }

    public void setText_constructor(String textConstructor) {
        this.textConstructor = textConstructor;
    }


    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public int getLimitChar() {
        return limitChar;
    }

    public ArrayList<String> getArrayList_Char() {
        return arrayList_Char;
    }

    public void setArrayList_Char(ArrayList<String> arrayList_Char) {
        this.arrayList_Char = arrayList_Char;
    }


    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getDownloadsFilePath() {
        return DownloadsFilePath;
    }

    public void setDownloadsFilePath(String downloadsFilePath) {
        DownloadsFilePath = downloadsFilePath;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }
}

class tesl {
    public static void main(String[] args) {
        List<DataStoreModel> latchList = new ArrayList<>();

        DataStoreModel d1 = new DataStoreModel(2, "latch1");
        DataStoreModel d2 = new DataStoreModel(2, "latch2");

        // Thêm các đối tượng MyCountDownLatch vào danh sách
        latchList.add(d1);
        latchList.add(d2);

        // Lặp qua danh sách và sử dụng các đối tượng MyCountDownLatch
        for (DataStoreModel latch : latchList) {
            System.out.println(latch.getCountDownLatchName());
            // Thực hiện các hoạt động khác với các latch nếu cần
        }
        try {
            latchList.get(0).getCountDownLatch().await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}