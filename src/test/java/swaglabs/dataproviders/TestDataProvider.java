package swaglabs.dataproviders;

import swaglabs.constants.Credentials;
import swaglabs.constants.InputDetails.*;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "RandomInputs")
    public static Object[][] randomInputs() {
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

    @DataProvider(name = "ValidZipPostalCodes")
    public static Object[][] validZipPostalCodes() {
        return new Object[][]{
                {"12345"},
                {"W1A 1AA"},
                {"110001"},
                {"75008"},
                {"1010"}
        };
    }

}

