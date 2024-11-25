package swaglabs.dataproviders;

import swaglabs.constants.Credentials;
import swaglabs.constants.InputConstants.*;
import org.testng.annotations.DataProvider;

public class LoginTestDataProvider {

    @DataProvider(name = "UsernameInputs")
    public static Object[][] usernameInputs() {
        return new Object[][]{
                {InputType.ALPHABET, InputLength.SHORT},
                {InputType.ALPHABET, InputLength.LONG},
                {InputType.COMPLEX, InputLength.SHORT},
                {InputType.COMPLEX, InputLength.LONG}
        };
    }

    @DataProvider(name = "PasswordInputs")
    public static Object[][] passwordInputs() {
        return new Object[][]{
                {InputType.ALPHABET, InputLength.SHORT},
                {InputType.ALPHABET, InputLength.LONG},
                {InputType.COMPLEX, InputLength.SHORT},
                {InputType.COMPLEX, InputLength.LONG}
        };
    }

    @DataProvider(name = "ValidUserCredentials")
    public static Object[][] validUserCredentials() {
        return new Object[][]{
                {Credentials.Usernames.STANDARD_USER},
                {Credentials.Usernames.PROBLEM_USER},
                {Credentials.Usernames.PERFORMANCE_GLITCH_USER},
                {Credentials.Usernames.ERROR_USER},
                {Credentials.Usernames.VISUAL_USER}
        };
    }
}

