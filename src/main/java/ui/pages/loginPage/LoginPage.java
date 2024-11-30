package ui.pages.loginPage;

import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;

public class LoginPage extends BasePage {
    private final LoginPageElements elements = new LoginPageElements(driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        sendKeys(elements.usernameField, username, "username field");
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(elements.passwordField, password, "password field");
        return this;
    }

    public LoginPage login() {
        click(elements.loginButton, "login button");
        return this;
    }

    public LoginPage closeErrorAlert() {
        click(elements.errorAlertCloseButton, "error alert close button");
        return this;
    }

    public String getErrorMessage() {
        return getText(elements.errorAlertMessage, "error alert message");
    }

    public String getInputFromUsernameField() {
        return getInputValue(elements.usernameField, "username field");
    }

    public String getInputFromPasswordField() {
        return getInputValue(elements.passwordField, "password field");
    }

    public void cleanUsernameField() {
        clearField(elements.usernameField, "username field");
    }

    public void cleanPasswordField() {
        clearField(elements.passwordField, "password field");
    }

    public boolean isWebsiteTitleVisible() {
        return explicitWaitForVisibility(elements.websiteTitle, "website title");
    }

    public boolean isErrorAlertVisible() {
        return explicitWaitForVisibility(elements.errorAlert, "error alert");
    }

    public boolean isUsernameErrorIconVisible() {
        return explicitWaitForVisibility(elements.usernameErrorIcon, "username error icon");
    }

    public boolean isPasswordErrorIconVisible() {
        return explicitWaitForVisibility(elements.passwordErrorIcon, "password error icon");
    }

    public boolean areCredentialsVisible() {
        return explicitWaitForVisibility(elements.loginUsernames, "login usernames")
                && explicitWaitForVisibility(elements.loginPassword, "login password");
    }
}
