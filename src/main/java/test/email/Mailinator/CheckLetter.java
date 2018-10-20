package test.email.Mailinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;


public class CheckLetter {

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver driver;

    @FindBy(xpath = "//tr[@class='even pointer ng-scope'][1]/td[3]")
    WebElement sender;

    @FindBy(xpath = "//tr[@class='even pointer ng-scope'][1]/td[4]")
    WebElement subject;

/*    @FindBy(xpath = "/html/body/div")
    WebElement letterContent;

    @FindBy(xpath = "//*[@id=\"msg_body\"]")
    WebElement frame;*/


    public CheckLetter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String CheckSenderName() {
        return sender.getText();
    }

    public String CheckSubject() {
        return subject.getText();
    }

  /*  public String CheckLetterContent() {
        subject.click();
        driver.switchTo().frame(frame);

        System.out.println(letterContent.getText());
        return letterContent.getText();
    }*/

}