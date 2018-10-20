package test.email.Mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMailinator {

    private WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "inboxfield")
    private WebElement loginField;

    @FindBy(className = "input-group-btn")
    private WebElement loginButton;

    public LoginMailinator(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,2);
        PageFactory.initElements(driver, this);
    }

    public CheckLetter checkLetter(String login){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FloatLogin")));
        loginField.sendKeys(login);
        loginButton.click();
        return new CheckLetter(driver);
    }


}