package ui.pages.checkoutCompletePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePageElements {

    @FindBy(className = "title")
    protected WebElement checkoutCompleteTitle;

    @FindBy(className = "pony_express")
    protected WebElement confirmationIcon;

    @FindBy(className = "complete-header")
    protected WebElement confirmationHeaderText;

    @FindBy(className = "complete-text")
    protected WebElement confirmationDescription;

    @FindBy(id = "back-to-products")
    protected WebElement backHomeButton;

    public CheckoutCompletePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
