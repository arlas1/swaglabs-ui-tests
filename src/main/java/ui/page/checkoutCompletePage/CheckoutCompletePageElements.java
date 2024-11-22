package ui.page.checkoutCompletePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePageElements {

    @FindBy(id = "title")
    protected WebElement checkoutCompleteText;

    @FindBy(id = "pony_express")
    protected WebElement confirmationIcon;

    @FindBy(id = "complete-header")
    protected WebElement confirmationHeader;

    @FindBy(id = "complete-text")
    protected WebElement confirmationDescription;

    @FindBy(id = "back-to-products")
    protected WebElement backHomeButton;

    public CheckoutCompletePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
