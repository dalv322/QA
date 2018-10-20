import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.rmi.runtime.Log;
import test.email.IUA.LoginIUA;
import test.email.Mailinator.CheckLetter;
import test.email.Mailinator.LoginMailinator;

import java.io.File;

public class EmailTest {
    static CheckLetter checkLetter;
    static String email = "123test.email@mailinator.com";
    static String loginIUA = "test.account123";
    static String loginMailinator = "123test.email";
    static String password = "1111qwE";
    static String subjectLetter = "Some Subject";
    static String textLetter = "Some Text";
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        String iua = "http://www.i.ua/";
        String mailnator = "https://www.mailinator.com/";

        File file = new File("C:\\ForSelenium\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        driver.get(iua);

        new LoginIUA(driver)
                .loginToIUa(loginIUA, password)
                .goToCreateNewLetter()
                .sendNewMessage(email, subjectLetter, textLetter);

        driver.get(mailnator);

        checkLetter = new LoginMailinator(driver).checkLetter(loginMailinator);

        driver.close();
    }

    @Test
    public void checkName(){
        Assert.assertEquals("Vladyslav Bezruk", checkLetter.CheckSenderName());
    }
    @Test
    public void checkSubject(){
        Assert.assertEquals("Some Subject", checkLetter.CheckSubject());
    }
}