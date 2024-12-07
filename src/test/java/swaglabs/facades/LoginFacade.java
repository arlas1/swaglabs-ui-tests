package swaglabs.facades;

import config.*;
import swaglabs.constants.Credentials;
import org.openqa.selenium.WebDriver;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.loginPage.LoginPage;

import static swaglabs.constants.InputDetails.*;
import static swaglabs.utils.CustomAssert.assertTrue;
import static swaglabs.utils.CustomAssert.assertEquals;
import static swaglabs.utils.RandomStringGenerator.generateRandomInput;

public class LoginFacade {
    private LoginPage loginPage;
    private CustomSoftAssert soft;

    private String expectedUsername;
    private String actualUsername;
    private String expectedPassword;
    private String actualPassword;
    private String actualErrorMessage;
    private String expectedErrorMessage;

    public LoginFacade(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.soft = new CustomSoftAssert();

    }

    public LoginFacade enterRandomUsername(InputType inputType, InputLength inputLength) {
        this.expectedUsername = generateRandomInput(inputType, inputLength);
        loginPage.enterUsername(this.expectedUsername);
        this.actualUsername = loginPage.getInputFromUsernameField();
        return this;
    }

    public LoginFacade enterRandomPassword(InputType inputType, InputLength inputLength) {
        this.expectedPassword = generateRandomInput(inputType, inputLength);
        loginPage.enterPassword(this.expectedPassword);
        this.actualPassword = loginPage.getInputFromPasswordField();
        return this;
    }

    public LoginFacade enterValidUsername(String credentials) {
        loginPage.enterUsername(credentials);
        return this;
    }

    public LoginFacade enterValidPassword() {
        loginPage.enterPassword(Credentials.PASSWORD);
        return this;
    }

    public LoginFacade login() {
        loginPage.login();
        return this;
    }

    public void verifyUsernameFieldStoresInput() {
        assertEquals(this.expectedUsername, this.actualUsername,
                "Verifying that username field stores the input."
        );
        loginPage.cleanUsernameField();

        this.expectedUsername = null;
        this.actualUsername = null;
    }

    public void verifyPasswordFieldStoresInput() {
        assertEquals(this.expectedPassword, this.actualPassword,
                "Verifying that password field stores the input."
        );
        loginPage.cleanPasswordField();

        this.expectedPassword = null;
        this.actualPassword = null;
    }

    public void verifyCredentialsAreVisible() {
        assertTrue(loginPage.areCredentialsVisible(),
                "Verifying that default credentials are visible."
        );
    }

    public void verifyError(String errorType) {
        this.expectedErrorMessage = loginPage.getErrorMessage();
        this.actualErrorMessage = errorType;

        soft.assertTrue(loginPage.isUsernameErrorIconVisible(),
                "Verifying that username error icon is visible."
        );
        soft.assertTrue(loginPage.isPasswordErrorIconVisible(),
                "Verifying that password error icon is visible."
        );
        soft.assertTrue(loginPage.isErrorAlertVisible(),
                "Verifying that error alert is visible."
        );
        soft.assertAll();

        assertEquals(this.expectedErrorMessage, this.actualErrorMessage,
                "Verifying that displayed error message matches the expected error message."
        );

        loginPage.closeErrorAlert();
        this.expectedErrorMessage = null;
        this.actualErrorMessage = null;
    }

    public void verifyRedirectTo(String redirectedToUrl) {
        String currentUrl = loginPage.getCurrentUrl();
        assertEquals(currentUrl, redirectedToUrl,
                "Verifying that user is redirected to the inventory page."
        );
        loginPage.openUrl(Config.baseUrl);
    }

    public void verifyWebsiteTitleIsVisible() {
        assertTrue(loginPage.isWebsiteTitleVisible(),
                "Verifying that website title is visible."
        );
    }
}
