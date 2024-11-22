package ui.page.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    @FindBy(className = "login_logo")
    protected WebElement websiteTitle;

    @FindBy(id = "user-name")
    protected WebElement usernameField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(className = "error-message-container")
    protected WebElement errorAlert;

    @FindBy(css = ".error-message-container.error h3")
    protected WebElement errorAlertMessage;

    @FindBy(css = "#user-name + .error_icon")
    protected WebElement usernameErrorIcon;

    @FindBy(css = "#password + .error_icon")
    protected WebElement passwordErrorIcon;

    @FindBy(className = "error-button")
    protected WebElement errorAlertCloseButton;

    @FindBy(id = "login-button")
    protected WebElement loginButton;

    @FindBy(id = "login_credentials")
    protected WebElement loginUsernames;

    @FindBy(className = "login_password")
    protected WebElement loginPassword;

    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
