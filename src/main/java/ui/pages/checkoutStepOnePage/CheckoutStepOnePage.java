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
        customActions.sendKeys(elements.firstnameField, firstname, "firstname field");
        return this;
    }

    public CheckoutStepOnePage enterLastname(String lastname) {
        customActions.sendKeys(elements.lastnameField, lastname, "lastname field");
        return this;
    }

    public CheckoutStepOnePage enterZipPostalCode(String zipPostalCode) {
        customActions.sendKeys(elements.zipPostalCodeField, zipPostalCode, "zip/postal code field");
        return this;
    }

    public CheckoutStepOnePage closeErrorAlert() {
        customActions.click(elements.errorAlertCloseButton, "error alert close button");
        return this;
    }

    public CheckoutStepOnePage goBackToCart() {
        customActions.click(elements.cancelButton, "cancel button");
        return this;
    }

    public CheckoutStepTwoPage continueCheckout() {
        customActions.click(elements.continueButton, "continue button");
        return new CheckoutStepTwoPage(driver);
    }

    public boolean isErrorAlertVisible() {
        return customActions.explicitWaitForVisibility(elements.errorAlert, "error alert");
    }

    public boolean isErrorAlertTextVisible() {
        return customActions.explicitWaitForVisibility(elements.errorAlertText, "error alert text");
    }

    public boolean isFirstnameFieldErrorIconVisible() {
        return customActions.explicitWaitForVisibility(elements.firstnameFieldErrorIcon, "firstname field error icon");
    }

    public boolean isLastnameFieldErrorIconVisible() {
        return customActions.explicitWaitForVisibility(elements.lastnameFieldErrorIcon, "lastname field error icon");
    }

    public boolean isZipPostalCodeFieldErrorIconVisible() {
        return customActions.explicitWaitForVisibility(elements.zipPostalCodeFieldErrorIcon, "zip/postal code field error icon");
    }
}
