package swaglabs.test.page;

import listener.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import static swaglabs.utils.common.RandomStringGenerator.generateAlphabetString;
import static swaglabs.utils.common.RandomStringGenerator.generateComplexString;
import static swaglabs.utils.test.CustomAssert.assertEquals;
import static swaglabs.utils.test.CustomAssert.assertTrue;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @AfterMethod
    public void uiCleanUp() {
        loginPage.reset();
    }

    @Test
    public void givenShortAlphabetOnlyInput_WhenEnteredInUsernameField_ThenAcceptedSuccessfully() {
        String expectedUsername = generateAlphabetString(10);
        loginPage.enterUsername(expectedUsername);

        String actualUsername = loginPage.getInputFromUsernameField();

        assertEquals(actualUsername, expectedUsername);
    }

    @Test
    public void givenLongAlphabetOnlyInput_WhenEnteredInUsernameField_ThenAcceptedSuccessfully() {
        String expectedUsername = generateAlphabetString(1000);
        loginPage.enterUsername(expectedUsername);

        String actualUsername = loginPage.getInputFromUsernameField();

        assertEquals(actualUsername, expectedUsername);
    }

    @Test
    public void givenShortComplexInput_WhenEnteredInUsernameField_ThenAcceptedSuccessfully() {
        String expectedUsername = generateComplexString(10);
        loginPage.enterUsername(expectedUsername);

        String actualUsername = loginPage.getInputFromUsernameField();

        assertEquals(actualUsername, expectedUsername);
    }

    @Test
    public void givenLongComplexInput_WhenEnteredInUsernameField_ThenAcceptedSuccessfully() {
        String expectedUsername = generateComplexString(1000);
        loginPage.enterUsername(expectedUsername);

        String actualUsername = loginPage.getInputFromUsernameField();

        assertEquals(actualUsername, expectedUsername);
    }

    @Test
    public void givenShortAlphabetOnlyInput_WhenEnteredInPasswordField_ThenAcceptedSuccessfully() {
        String expectedPassword = generateAlphabetString(10);
        loginPage.enterPassword(expectedPassword);

        String actualPassword = loginPage.getInputFromPasswordField();

        assertEquals(actualPassword, expectedPassword);
    }

    @Test
    public void givenLongAlphabetOnlyInput_WhenEnteredInPasswordField_ThenAcceptedSuccessfully() {
        String expectedPassword = generateAlphabetString(1000);
        loginPage.enterPassword(expectedPassword);

        String actualPassword = loginPage.getInputFromPasswordField();

        assertEquals(actualPassword, expectedPassword);
    }

    @Test
    public void givenShortComplexInput_WhenEnteredInPasswordField_ThenAcceptedSuccessfully() {
        String expectedPassword = generateComplexString(10);
        loginPage.enterPassword(expectedPassword);

        String actualPassword = loginPage.getInputFromPasswordField();

        assertEquals(actualPassword, expectedPassword);
    }

    @Test
    public void givenLongComplexInput_WhenEnteredInPasswordField_ThenAcceptedSuccessfully() {
        String expectedPassword = generateComplexString(100);
        loginPage.enterPassword(expectedPassword);

        String actualPassword = loginPage.getInputFromPasswordField();

        assertEquals(actualPassword, expectedPassword);
    }

    @Test
    public void givenPossibleCredentialsOnThePage_WhenPageLoads_ThenCredentialsAreVisible() {
        boolean userCredentialAreVisible = loginPage.areUserCredentialsVisible();
        assertTrue(userCredentialAreVisible);
    }

    @Test
    public void givenClearUsernameAndPasswordFields_WhenSubmitForm_ThenErrorAlertDisplayedWithCorrespondingMessage_ThenErrorAlertCanBeClosed() {
        loginPage.login();
        String expectedErrorMessage = "Epic sadface: Username is required";

        boolean errorAlertDisplayed = loginPage.isErrorAlertVisible();
        String actualErrorMessage = loginPage.getErrorMessage();

        assertTrue(errorAlertDisplayed);
        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void givenUsernameFieldWithSampleInputAndClearPasswordField_WhenSubmitForm_ThenErrorAlertDisplayedWithCorrespondingMessage() {
        String sampleUsername = generateAlphabetString(10);
        loginPage.enterUsername(sampleUsername);

        loginPage.login();
        String expectedErrorMessage = "Epic sadface: Password is required";

        boolean errorAlertDisplayed = loginPage.isErrorAlertVisible();
        String actualErrorMessage = loginPage.getErrorMessage();

        assertTrue(errorAlertDisplayed);
        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void givenUsernameAndPasswordWithInvalidInputs_WhenSubmitForm_ThenErrorAlertDisplayedWithCorrespondingMessage() {
        String sampleUsername = generateAlphabetString(10);
        String samplePassword = generateAlphabetString(10);
        loginPage.enterUsername(sampleUsername);
        loginPage.enterPassword(samplePassword);

        loginPage.login();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        boolean errorAlertDisplayed = loginPage.isErrorAlertVisible();
        String actualErrorMessage = loginPage.getErrorMessage();

        assertTrue(errorAlertDisplayed);
        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

}
