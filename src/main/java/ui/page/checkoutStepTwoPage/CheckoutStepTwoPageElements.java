package ui.page.checkoutStepTwoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutStepTwoPageElements {

    @FindBy(className = "title")
    protected WebElement checkoutOverviewText;

    @FindBy(className = "cart_quantity_label")
    protected WebElement qtyText;

    @FindBy(className = "cart_desc_label")
    protected WebElement descriptionText;

    @FindBy(className = "cart_list")
    protected List<WebElement> itemsList;

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
