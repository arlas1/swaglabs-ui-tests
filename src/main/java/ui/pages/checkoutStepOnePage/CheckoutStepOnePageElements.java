package ui.pages.checkoutStepOnePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePageElements {

    @FindBy(id = "first-name")
    protected WebElement firstnameField;

    @FindBy(id = "last-name")
    protected WebElement lastnameField;

    @FindBy(id = "postal-code")
    protected WebElement zipPostalCodeField;

    @FindBy(className = "error")
    protected WebElement errorAlert;

    @FindBy(css = "h3[data-test='error']")
    protected WebElement errorAlertMessage;

    @FindBy(className = "error-button")
    protected WebElement errorAlertCloseButton;

    @FindBy(css = "#first-name + .error_icon")
    protected WebElement firstnameFieldErrorIcon;

    @FindBy(css = "#last-name + .error_icon")
    protected WebElement lastnameFieldErrorIcon;

    @FindBy(css = "#postal-code + .error_icon")
    protected WebElement zipPostalCodeFieldErrorIcon;

    @FindBy(id = "cancel")
    protected WebElement cancelButton;

    @FindBy(id = "continue")
    protected WebElement continueButton;

    public CheckoutStepOnePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
