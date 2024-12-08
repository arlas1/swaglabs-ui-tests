package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.checkoutStepOnePage.CheckoutStepOnePage;

import static swaglabs.constants.InputDetails.*;
import static swaglabs.constants.PageUrl.*;
import static swaglabs.utils.CustomAssert.assertEquals;
import static swaglabs.utils.RandomStringGenerator.generateRandomInput;

public class CheckoutStepOneFacade{
    private CheckoutStepOnePage checkoutStepOnePage;
    private CustomSoftAssert soft;
    private String expectedFirstName;
    private String actualFirstName;
    private String expectedLastName;
    private String actualLastName;
    private String expectedZipPostalCode;
    private String actualZipPostalCode;
    private String actualErrorMessage;
    private String expectedErrorMessage;

    public CheckoutStepOneFacade(WebDriver driver) {
        this.checkoutStepOnePage = new CheckoutStepOnePage(driver);
        this.soft = new CustomSoftAssert();
    }

    public CheckoutStepOneFacade enterRandomFirstName(InputType inputType, InputLength inputLength) {
        this.expectedFirstName = generateRandomInput(inputType, inputLength);
        checkoutStepOnePage.enterFirstname(expectedFirstName);
        return this;
    }

    public CheckoutStepOneFacade enterRandomLastName(InputType inputType, InputLength inputLength) {
        this.expectedLastName = generateRandomInput(inputType, inputLength);
        checkoutStepOnePage.enterLastname(expectedLastName);
        return this;
    }

    public CheckoutStepOneFacade enterZipPostalCode(String zipPostalCode) {
        this.expectedZipPostalCode = zipPostalCode;
        checkoutStepOnePage.enterZipPostalCode(zipPostalCode);
        return this;
    }

    public CheckoutStepOneFacade continueCheckout() {
        checkoutStepOnePage.continueCheckout();
        return this;
    }

    public CheckoutStepOneFacade cleanFirstnameField(){
        checkoutStepOnePage.cleanFirstnameField();
        return this;
    }

    public CheckoutStepOneFacade cleanLastnameField(){
        checkoutStepOnePage.cleanLastnameField();
        return this;
    }

    public CheckoutStepOneFacade cleanZipPostalCodeField(){
        checkoutStepOnePage.cleanZipPostalCodeField();
        return this;
    }

    public CheckoutStepOneFacade goBackToCart () {
        checkoutStepOnePage.goBackToCart();
        return this;
    }

    public void verifyError(String errorType) {
        this.expectedErrorMessage = checkoutStepOnePage.getErrorMessage();
        this.actualErrorMessage = errorType;

        checkoutStepOnePage.cleanFirstnameField();
        checkoutStepOnePage.cleanLastnameField();
        checkoutStepOnePage.cleanZipPostalCodeField();

        soft.assertTrue(checkoutStepOnePage.isFirstnameFieldErrorIconVisible(),
                "Verifying that firstname error icon is visible."
        );
        soft.assertTrue(checkoutStepOnePage.isLastnameFieldErrorIconVisible(),
                "Verifying that lastname error icon is visible."
        );
        soft.assertTrue(checkoutStepOnePage.isZipPostalCodeFieldErrorIconVisible(),
                "Verifying that zip/postal code error icon is visible."
        );
        soft.assertTrue(checkoutStepOnePage.isErrorAlertVisible(),
                "Verifying that error alert is visible."
        );
        soft.assertAll();
        assertEquals(this.expectedErrorMessage, this.actualErrorMessage,
                "Verifying that displayed error message matches the expected error message."
        );

        checkoutStepOnePage.closeErrorAlert();

        this.expectedErrorMessage = null;
        this.actualErrorMessage = null;
    }

    public void verifyFirstNameFieldStoresInput() {
        this.actualFirstName = checkoutStepOnePage.getInputFromFirstNameField();
        assertEquals(this.expectedFirstName, this.actualFirstName,
                "Verifying that firstname field stores the input."
        );
        this.expectedFirstName = null;
        this.actualFirstName = null;
    }

    public void verifyLastNameFieldStoresInput(){
        this.actualLastName = checkoutStepOnePage.getInputFromLastnameField();
        assertEquals(this.expectedLastName, this.actualLastName,
                "Verifying that lastname field stores the input."
        );
        this.expectedLastName = null;
        this.actualLastName = null;
    }

    public void verifyZipPostalCodeFieldStoresInput() {
        this.actualZipPostalCode = checkoutStepOnePage.getInputZipPostalCodeField();
        assertEquals(this.expectedZipPostalCode, this.actualZipPostalCode,
                "Verifying that zip/postal code field stores the input."
        );
        this.expectedZipPostalCode = null;
        this.actualZipPostalCode = null;
    }

    public void verifyRedirectTo(String redirectedToUrl) {
        String currentUrl = checkoutStepOnePage.getCurrentUrl();
        assertEquals(currentUrl, redirectedToUrl,
                "Verifying that user is redirected to the checkout step two page."
        );
        checkoutStepOnePage.openUrl(CHECKOUT_STEP_ONE_PAGE);

    }
}
