package test.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.email.IUA.LoginIUA;
import test.email.Mailinator.LoginMailinator;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String iua = "http://www.i.ua/";
        String mailnator = "https://www.mailinator.com/";

        File file = new File("C:\\ForSelenium\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();

        driver.get(iua);

        String email = "123test.email@mailinator.com";
        String loginIUA = "test.account123";
        String loginMailinator = "123test.email";
        String password = "1111qwE";
        String subjectLetter = "Some Subject";
        String textLetter = "Some Text";

        new LoginIUA(driver)
                .loginToIUa(loginIUA, password)
                .goToCreateNewLetter()
                .sendNewMessage(email, subjectLetter, textLetter);

        driver.get(mailnator);

        new LoginMailinator(driver)
                .checkLetter(loginMailinator);

        driver.close();
    }
}
