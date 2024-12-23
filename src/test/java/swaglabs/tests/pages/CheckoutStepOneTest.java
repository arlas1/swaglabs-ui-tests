package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.dataproviders.TestDataProvider;
import swaglabs.facades.CheckoutStepOneFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.InputDetails.*;
import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class CheckoutStepOneTest extends BaseTest {
    private CheckoutStepOneFacade checkoutStepOneFacade;
    private final String ZIP_POSTAL_CODE = "11211";

    @BeforeClass
    public void loginToAccessInventoryPage_ThenOpenItemPage_ThenOpenCartPage_ThenProceedToCheckoutStepOne() {
        SetUp setUp = new SetUp(driver);
        setUp
             .loginAsStandardUser()
             .addTwoItemsToCartAndOpenCart()
             .proceedToCheckoutStepOne();
        this.checkoutStepOneFacade = new CheckoutStepOneFacade(driver);
    }

    @Test(dataProvider = "RandomInputs", dataProviderClass = TestDataProvider.class, priority = 1)
    public void givenRandomInput_WhenEnteredIntoFirstnameField_ThenFieldStoresInput(InputType inputType, InputLength inputLength) {
        checkoutStepOneFacade
                .enterRandomFirstName(inputType, inputLength)
                .verifyFirstNameFieldStoresInput();
    }

    @Test(dataProvider = "RandomInputs", dataProviderClass = TestDataProvider.class, priority = 2)
    public void givenRandomInput_WhenEnteredIntoLastnameField_ThenFieldStoresInput(InputType inputType, InputLength inputLength) {
        checkoutStepOneFacade
                .enterRandomLastName(inputType, inputLength)
                .verifyLastNameFieldStoresInput();
    }

    @Test(dataProvider = "ValidZipPostalCodes", dataProviderClass = TestDataProvider.class, priority = 3)
    public void givenValidInput_WhenEnteredIntoZipPostalCodeField_ThenFieldStoresInput(String validZipPostalCode) {
        checkoutStepOneFacade
                .enterZipPostalCode(validZipPostalCode)
                .verifyZipPostalCodeFieldStoresInput();
    }

//    @Test(priority = 4)
//    public void givenEmptyFirstNameAndLastNameAndZipPostalCode_WhenContinueAttempted_ThenFirstNameRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .continueCheckout()
//                .verifyError(FIRSTNAME_REQUIRED);
//    }
//
//    @Test(priority = 5)
//    public void givenFirstNameEnteredAndLastNameAndZipPostalCodeEmpty_WhenContinueAttempted_ThenLastNameRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .enterRandomFirstName(InputType.ALPHABET, InputLength.SHORT)
//                .continueCheckout()
//                .verifyError(LASTNAME_REQUIRED);
//    }
//
//    @Test(priority = 6)
//    public void givenLastNameEnteredAndFirstNameAndZipPostalCodeEmpty_WhenContinueAttempted_ThenFirstNameRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .enterRandomLastName(InputType.ALPHABET, InputLength.SHORT)
//                .continueCheckout()
//                .verifyError(FIRSTNAME_REQUIRED);
//    }
//
//    @Test(priority = 7)
//    public void givenZipPostalCodeEnteredAndFirstNameAndLastNameEmpty_WhenContinueAttempted_ThenFirstNameRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .enterZipPostalCode(ZIP_POSTAL_CODE)
//                .continueCheckout()
//                .verifyError(FIRSTNAME_REQUIRED);
//    }
//
//    @Test(priority = 8)
//    public void givenFirstNameAndLastNameEnteredAndZipPostalCodeEmpty_WhenContinueAttempted_ThenPostalCodeRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .enterRandomFirstName(InputType.ALPHABET, InputLength.SHORT)
//                .enterRandomLastName(InputType.ALPHABET, InputLength.SHORT)
//                .continueCheckout()
//                .verifyError(POSTAL_CODE_REQUIRED);
//    }
//
//    @Test(priority = 9)
//    public void givenFirstNameAndZipPostalCodeEnteredAndLastNameEmpty_WhenContinueAttempted_ThenLastNameRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .enterRandomFirstName(InputType.ALPHABET, InputLength.SHORT)
//                .enterZipPostalCode(ZIP_POSTAL_CODE)
//                .continueCheckout()
//                .verifyError(LASTNAME_REQUIRED);
//    }
//
//    @Test(priority = 10)
//    public void givenLastNameAndZipPostalCodeEnteredAndFirstNameEmpty_WhenContinueAttempted_ThenFirstNameRequiredErrorDisplayed() throws InterruptedException {
//        checkoutStepOneFacade
//                .enterRandomLastName(InputType.ALPHABET, InputLength.SHORT)
//                .enterZipPostalCode(ZIP_POSTAL_CODE)
//                .continueCheckout()
//                .verifyError(FIRSTNAME_REQUIRED);
//    }
//
//    @Test(priority = 11)
//    public void givenFirstNameAndLastNameAndZipPostalCodeEntered_WhenContinueAttempted_ThenUserIsRedirectedToCheckoutStepTwoPage() {
//        checkoutStepOneFacade
//                .enterRandomFirstName(InputType.ALPHABET, InputLength.SHORT)
//                .enterRandomLastName(InputType.ALPHABET, InputLength.SHORT)
//                .enterZipPostalCode(ZIP_POSTAL_CODE)
//                .continueCheckout()
//                .verifyRedirectTo(CHECKOUT_STEP_TWO_PAGE);
//    }

    @Test(priority = 12)
    public void givenCancelButton_WhenClickedOn_ThenUserIsRedirectedToCartPage() {
        checkoutStepOneFacade
                .goBackToCart()
                .verifyRedirectTo(CART_PAGE);
    }
}
