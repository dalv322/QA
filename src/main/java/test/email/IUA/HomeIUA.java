package test.email.IUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeIUA {
    private WebDriver driver;

    @FindBy(className = "mbox_16")
    private WebElement EmailBtn;

    @FindBy(className = "make_message")
    private WebElement createLetterButton;

    @FindBy(xpath = "xpath")
    private WebElement inboxMessages;



    public HomeIUA(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewLetterPage goToCreateNewLetter() {
        EmailBtn.click();
        createLetterButton.click();
        return new NewLetterPage(driver);
    }


}