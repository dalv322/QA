package test.email.IUA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginIUA {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "first")
    private WebElement showLoginFormButton;

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]/div/div/form/fieldset/p[1]/input")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]/div/div/form/fieldset/p[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]/div/div/form/input[6]")
    private WebElement loginButton;

    public LoginIUA(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,2);
        PageFactory.initElements(driver, this);
    }

    public HomeIUA loginToIUa(String login, String password){
        showLoginFormButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FloatLogin")));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomeIUA(driver);
    }

}