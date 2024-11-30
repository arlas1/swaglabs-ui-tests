package swaglabs.tests.pages;

import swaglabs.constants.InputConstants.InputLength;
import swaglabs.constants.InputConstants.InputType;
import listener.TestListener;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import swaglabs.dataproviders.LoginTestDataProvider;

import static swaglabs.constants.Credentials.Usernames;
import static swaglabs.constants.ErrorConstants.ErrorType.*;
import static swaglabs.constants.PageUrlConstants.PageUrl.INVENTORY_PAGE_URL;

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
                .verifyRedirectTo(INVENTORY_PAGE_URL);
    }

    @Test
    public void givenEmptyUsernameAndPassword_WhenLoginAttempted_ThenUsernameRequiredErrorDisplayed() {
        loginPageFacade
                .login()
                .verifyErrorMessage(USERNAME_REQUIRED);
    }

    @Test
    public void givenUsernameEnteredAndPasswordEmpty_WhenLoginAttempted_ThenPasswordRequiredErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyErrorMessage(PASSWORD_REQUIRED);
    }

    @Test
    public void givenInvalidUsernameAndInvalidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .enterRandomPassword(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyErrorMessage(INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenInvalidUsernameAndValidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .enterValidPassword()
                .login()
                .verifyErrorMessage(INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenValidUsernameAndInvalidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterValidUsername(Usernames.STANDARD_USER)
                .enterRandomPassword(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyErrorMessage(INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenLockedOutUserCredentials_WhenLoginAttempted_ThenUserLockedErrorDisplayed() {
        loginPageFacade
                .enterValidUsername(Usernames.LOCKED_OUT_USER)
                .enterValidPassword()
                .login()
                .verifyErrorMessage(USER_LOCKED);
    }

    @Test
    public void givenDefaultCredentials_WhenLoginPageIsLoaded_ThenDefaultCredentialsAreVisible() {
        loginPageFacade.verifyCredentialsAreVisible();
    }

    @Test
    public void givenWebsiteTitle_WhenLoginPageIsLoaded_ThenWebsiteTitleIsVisible() {
        loginPageFacade.verifyWebsiteTitleIsVisible();
    }
}
