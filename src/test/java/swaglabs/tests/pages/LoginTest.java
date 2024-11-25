package swaglabs.tests.pages;

import swaglabs.constants.Credentials;
import swaglabs.constants.InputConstants.InputLength;
import swaglabs.constants.InputConstants.InputType;
import listener.TestListener;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import swaglabs.dataproviders.LoginTestDataProvider;
import swaglabs.constants.ErrorConstants.*;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "UsernameInputs", dataProviderClass = LoginTestDataProvider.class)
    public void givenRandomInput_WhenEnteredIntoUsernameField_ThenFieldStoresInput(InputType inputType, InputLength inputLength) {
        loginPageFacade
                .enterRandomUsername(inputType, inputLength)
                .getInputFromUsernameField()
                .verifyUsernameFieldStoresInput();
    }

    @Test(dataProvider = "PasswordInputs", dataProviderClass = LoginTestDataProvider.class)
    public void givenRandomInput_WhenEnteredIntoPasswordField_ThenFieldStoresInput(InputType inputType, InputLength inputLength) {
        loginPageFacade
                .enterRandomPassword(inputType, inputLength)
                .getInputFromPasswordField()
                .verifyPasswordFieldStoresInput();
    }

    @Test(dataProvider = "ValidUserCredentials", dataProviderClass = LoginTestDataProvider.class)
    public void givenValidUserCredentials_WhenLoginAttempted_ThenUserIsRedirectedToInventoryPage(String username) {
        loginPageFacade
                .enterValidUsername(username)
                .enterValidPassword()
                .login()
                .verifyRedirectToInventoryPage();
    }

    @Test
    public void givenEmptyUsernameAndPassword_WhenLoginAttempted_ThenUsernameRequiredErrorDisplayed() {
        loginPageFacade
                .login()
                .verifyErrorMessage(ErrorType.USERNAME_REQUIRED);
    }

    @Test
    public void givenUsernameEnteredAndPasswordEmpty_WhenLoginAttempted_ThenPasswordRequiredErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyErrorMessage(ErrorType.PASSWORD_REQUIRED);
    }

    @Test
    public void givenInvalidUsernameAndInvalidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .enterRandomPassword(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyErrorMessage(ErrorType.INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenInvalidUsernameAndValidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .enterValidPassword()
                .login()
                .verifyErrorMessage(ErrorType.INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenValidUsernameAndInvalidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterValidUsername(Credentials.Usernames.STANDARD_USER)
                .enterRandomPassword(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyErrorMessage(ErrorType.INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenLockedOutUserCredentials_WhenLoginAttempted_ThenUserLockedErrorDisplayed() {
        loginPageFacade
                .enterValidUsername(Credentials.Usernames.LOCKED_OUT_USER)
                .enterValidPassword()
                .login()
                .verifyErrorMessage(ErrorType.USER_LOCKED);
    }

    @Test
    public void givenLoginPage_WhenLoaded_ThenDefaultCredentialsAreVisible() {
        loginPageFacade.verifyCredentialsAreVisible();
    }

    @Test
    void givenLoginPage_WhenLoaded_ThenWebsiteTitleIsVisible() {
        loginPageFacade.verifyWebsiteTitleIsVisible();
    }
}
