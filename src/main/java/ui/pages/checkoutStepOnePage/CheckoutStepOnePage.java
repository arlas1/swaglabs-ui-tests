package ui.pages.checkoutStepOnePage;

import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;
import ui.pages.checkoutStepTwoPage.CheckoutStepTwoPage;

public class CheckoutStepOnePage extends BasePage {
    private final CheckoutStepOnePageElements elements = new CheckoutStepOnePageElements(driver);

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepOnePage enterFirstname(String firstname) {
        sendKeys(elements.firstnameField, firstname, "firstname field");
        return this;
    }

    public CheckoutStepOnePage enterLastname(String lastname) {
        sendKeys(elements.lastnameField, lastname, "lastname field");
        return this;
    }

    public CheckoutStepOnePage enterZipPostalCode(String zipPostalCode) {
        sendKeys(elements.zipPostalCodeField, zipPostalCode, "zip/postal code field");
        return this;
    }

    public CheckoutStepOnePage closeErrorAlert() {
        click(elements.errorAlertCloseButton, "error alert close button");
        return this;
    }

    public CheckoutStepOnePage goBackToCart() {
        click(elements.cancelButton, "cancel button");
        return this;
    }

    public CheckoutStepTwoPage continueCheckout() {
        click(elements.continueButton, "continue button");
        return new CheckoutStepTwoPage(driver);
    }

    public boolean isErrorAlertVisible() {
        return explicitWaitForVisibility(elements.errorAlert, "error alert");
    }

    public boolean isErrorAlertTextVisible() {
        return explicitWaitForVisibility(elements.errorAlertText, "error alert text");
    }

    public boolean isFirstnameFieldErrorIconVisible() {
        return explicitWaitForVisibility(elements.firstnameFieldErrorIcon, "firstname field error icon");
    }

    public boolean isLastnameFieldErrorIconVisible() {
        return explicitWaitForVisibility(elements.lastnameFieldErrorIcon, "lastname field error icon");
    }

    public boolean isZipPostalCodeFieldErrorIconVisible() {
        return explicitWaitForVisibility(elements.zipPostalCodeFieldErrorIcon, "zip/postal code field error icon");
    }
}
