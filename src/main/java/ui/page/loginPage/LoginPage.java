package ui.page.loginPage;

import org.openqa.selenium.WebDriver;
import ui.page.BasePage;

public class LoginPage extends BasePage {
    private final LoginPageElements elements = new LoginPageElements(driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        customActions.sendKeys(elements.usernameField, username, "username field");
        return this;
    }

    public LoginPage enterPassword(String password) {
        customActions.sendKeys(elements.passwordField, password, "password field");
        return this;
    }

    public LoginPage login() {
        customActions.click(elements.loginButton, "login button");
        return this;
    }

    public LoginPage closeErrorAlert() {
        customActions.click(elements.errorAlertCloseButton, "error alert close button");
        return this;
    }

    public String getErrorMessage() {
        return customActions.getText(elements.errorAlertMessage, "error alert message");
    }

    public String getInputFromUsernameField() {
        return customActions.getInputValue(elements.usernameField, "username field");
    }

    public String getInputFromPasswordField() {
        return customActions.getInputValue(elements.passwordField, "password field");
    }

    public void cleanUsernameField() {
        customActions.clearField(elements.usernameField, "username field");
    }

    public void cleanPasswordField() {
        customActions.clearField(elements.passwordField, "password field");
    }

    public void reset() {
        if (getInputFromUsernameField() != "") {
            cleanUsernameField();
        }
        if (getInputFromPasswordField() != "") {
            cleanPasswordField();
        }
        if (isErrorAlertVisible()) {
            cleanPasswordField();
        }
    }

    public boolean isWebsiteTitleVisible() {
        return customActions.explicitWaitForVisibility(elements.websiteTitle, "website title");
    }

    public boolean isErrorAlertVisible() {
        return customActions.explicitWaitForVisibility(elements.errorAlert, "error alert");
    }

    public boolean isUsernameErrorIconVisible() {
        return customActions.explicitWaitForVisibility(elements.usernameErrorIcon, "username error icon");
    }

    public boolean isPasswordErrorIconVisible() {
        return customActions.explicitWaitForVisibility(elements.passwordErrorIcon, "password error icon");
    }

    public boolean areUserCredentialsVisible() {
        return customActions.explicitWaitForVisibility(elements.loginUsernames, "login usernames")
                && customActions.explicitWaitForVisibility(elements.loginPassword, "login password");
    }
}
