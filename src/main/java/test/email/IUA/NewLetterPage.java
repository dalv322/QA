package test.email.IUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage {

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver driver;

    @FindBy(id = "to")
    WebElement sendTo;

    @FindBy(xpath = "/html/body/div[4]/div[5]/div[1]/div[1]/div[1]/div/form/div[5]/div[2]/span/input[1]")
    WebElement subject;

    @FindBy(id = "text")
    WebElement letterContent;

    @FindBy(xpath = "/html/body/div[4]/div[5]/div[1]/div[1]/p[1]/input[1]")
    WebElement sendButton;

    @FindBy(css= ".classname")
    WebElement inboxButton;

    @FindBy(xpath = "xpath")
    WebElement inboxPageButton;

    public NewLetterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewLetterPage sendNewMessage(String email, String letterSubject, String letterText) {
        sendTo.sendKeys(email);
        subject.sendKeys(letterSubject);
        letterContent.sendKeys(letterText);
        sendButton.click();
        return new NewLetterPage(driver);
    }


}