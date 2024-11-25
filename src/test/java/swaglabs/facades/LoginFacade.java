package swaglabs.facades;

import config.*;
import swaglabs.constants.Credentials;
import swaglabs.constants.RedirectLinks;
import org.openqa.selenium.WebDriver;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.loginPage.LoginPage;
import swaglabs.constants.ErrorConstants;
import swaglabs.constants.InputConstants.InputLength;
import swaglabs.constants.InputConstants.InputType;

import static swaglabs.utils.CustomAssert.assertEquals;
import static swaglabs.utils.CustomAssert.assertTrue;
import static swaglabs.utils.RandomStringGenerator.generateRandomInput;

public class LoginFacade {
    private final CustomSoftAssert soft = new CustomSoftAssert();
    private final LoginPage loginPage;

    private String expectedUsername;
    private String actualUsername;

    private String expectedPassword;
    private String actualPassword;

    private String actualErrorMessage;
    private String expectedErrorMessage;

    public LoginFacade(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public LoginFacade enterRandomUsername(InputType inputType, InputLength inputLength) {
        this.expectedUsername = generateRandomInput(inputType, inputLength);
        loginPage.enterUsername(this.expectedUsername);
        return this;
    }

    public LoginFacade enterRandomPassword(InputType inputType, InputLength inputLength) {
        this.expectedPassword = generateRandomInput(inputType, inputLength);
        loginPage.enterPassword(this.expectedPassword);
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

    public LoginFacade getInputFromUsernameField() {
        this.actualUsername = loginPage.getInputFromUsernameField();
        return this;
    }

    public LoginFacade getInputFromPasswordField() {
        this.actualPassword = loginPage.getInputFromPasswordField();
        return this;
    }

    public void verifyUsernameFieldStoresInput() {
        assertEquals(this.expectedUsername, this.actualUsername,
                "Verifying that the username field stores the input."
        );
        loginPage.cleanUsernameField();

        this.expectedUsername = null;
        this.actualUsername = null;
    }

    public void verifyPasswordFieldStoresInput() {
        assertEquals(this.expectedPassword, this.actualPassword,
                "Verifying that the password field stores the input."
        );
        loginPage.cleanPasswordField();

        this.expectedPassword = null;
        this.actualPassword = null;
    }

    public void verifyCredentialsAreVisible() {
        assertTrue(loginPage.areCredentialsVisible(),
                "Verifying that the default credentials are visible on the login page."
        );
    }

    public LoginFacade login() {
        loginPage.login();
        return this;
    }

    public void verifyErrorMessage(ErrorConstants.ErrorType errorType) {
        this.expectedErrorMessage = loginPage.getErrorMessage();
        this.actualErrorMessage = errorType.getMessage();

        soft.assertTrue(loginPage.isUsernameErrorIconVisible(),
                "Verifying that the username error icon is visible."
        );
        soft.assertTrue(loginPage.isPasswordErrorIconVisible(),
                "Verifying that the password error icon is visible."
        );
        assertTrue(loginPage.isErrorAlertVisible(),
                "Verifying that the error alert is visible."
        );
        assertEquals(this.expectedErrorMessage, this.actualErrorMessage,
                "Verifying that the displayed error message matches the expected error message."
        );

        loginPage.closeErrorAlert();
        this.expectedErrorMessage = null;
        this.actualErrorMessage = null;
    }

    public void verifyRedirectToInventoryPage() {
        String currentUrl = loginPage.getCurrentUrl("inventory page");
        assertEquals(currentUrl, RedirectLinks.INVENTORY_PAGE_URL,
                "Verifying that the user is redirected to the inventory page after login."
        );
        loginPage.openUrl(Config.baseUrl);
    }

    public void verifyWebsiteTitleIsVisible() {
        assertTrue(loginPage.isWebsiteTitleVisible(),
                "Verifying that the website title is visible on the login page."
        );
    }
}
