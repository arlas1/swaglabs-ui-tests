package swaglabs.tests.pages;

import swaglabs.constants.InputDetails.InputLength;
import swaglabs.constants.InputDetails.InputType;
import listener.TestListener;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import swaglabs.dataproviders.TestDataProvider;

import static swaglabs.constants.ErrorMessage.*;
import static swaglabs.constants.PageUrl.*;
import static swaglabs.constants.Credentials.Usernames;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "RandomInputs", dataProviderClass = TestDataProvider.class)
    public void givenRandomInput_WhenEnteredIntoUsernameField_ThenFieldStoresInput(InputType inputType, InputLength inputLength) {
        loginPageFacade
                .enterRandomUsername(inputType, inputLength)
                .verifyUsernameFieldStoresInput();
    }

    @Test(dataProvider = "RandomInputs", dataProviderClass = TestDataProvider.class)
    public void givenRandomInput_WhenEnteredIntoPasswordField_ThenFieldStoresInput(InputType inputType, InputLength inputLength) {
        loginPageFacade
                .enterRandomPassword(inputType, inputLength)
                .verifyPasswordFieldStoresInput();
    }

    @Test(dataProvider = "ValidUserCredentials", dataProviderClass = TestDataProvider.class)
    public void givenValidUserCredentials_WhenLoginAttempted_ThenUserIsRedirectedToInventoryPage(String username) {
        loginPageFacade
                .enterValidUsername(username)
                .enterValidPassword()
                .login()
                .verifyRedirectTo(INVENTORY_PAGE);
    }

    @Test
    public void givenEmptyUsernameAndPassword_WhenLoginAttempted_ThenUsernameRequiredErrorDisplayed() {
        loginPageFacade
                .login()
                .verifyError(USERNAME_REQUIRED);
    }

//    @Test
//    public void givenUsernameEnteredAndPasswordEmpty_WhenLoginAttempted_ThenPasswordRequiredErrorDisplayed() {
//        loginPageFacade
//                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
//                .login()
//                .verifyError(PASSWORD_REQUIRED);
//    }

    @Test
    public void givenInvalidUsernameAndInvalidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .enterRandomPassword(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyError(INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenInvalidUsernameAndValidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterRandomUsername(InputType.ALPHABET, InputLength.SHORT)
                .enterValidPassword()
                .login()
                .verifyError(INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenValidUsernameAndInvalidPassword_WhenLoginAttempted_ThenInvalidCredentialsErrorDisplayed() {
        loginPageFacade
                .enterValidUsername(Usernames.STANDARD_USER)
                .enterRandomPassword(InputType.ALPHABET, InputLength.SHORT)
                .login()
                .verifyError(INVALID_USERNAME_OR_PASSWORD);
    }

    @Test
    public void givenLockedOutUserCredentials_WhenLoginAttempted_ThenUserLockedErrorDisplayed() {
        loginPageFacade
                .enterValidUsername(Usernames.LOCKED_OUT_USER)
                .enterValidPassword()
                .login()
                .verifyError(USER_LOCKED);
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
