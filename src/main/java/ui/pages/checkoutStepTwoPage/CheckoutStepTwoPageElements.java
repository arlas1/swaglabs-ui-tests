package ui.pages.checkoutStepTwoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutStepTwoPageElements {

    @FindBy(className = "title")
    protected WebElement checkoutOverviewTitle;

    @FindBy(className = "cart_quantity_label")
    protected WebElement qtyLabel;

    @FindBy(className = "cart_desc_label")
    protected WebElement descriptionLabel;

    @FindBy(css = "div.cart_item")
    protected List<WebElement> cartItems;

    @FindBy(className = "summary_info")
    protected WebElement paymentSummaryText;

    @FindBy(className = "summary_subtotal_label")
    protected WebElement itemsTotalPrice;

    @FindBy(id = "cancel")
    protected WebElement cancelButton;

    @FindBy(id = "finish")
    protected WebElement finishButton;

    public CheckoutStepTwoPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
