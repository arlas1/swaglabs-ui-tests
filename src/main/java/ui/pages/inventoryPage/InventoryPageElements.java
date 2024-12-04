package ui.pages.inventoryPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPageElements {

    @FindBy(className = "title")
    protected WebElement itemTitle;

    @FindBy(css = "div.inventory_item")
    protected List<WebElement> inventoryItems;

    @FindBy(className = "product_sort_container")
    protected WebElement filterSelect;

    @FindBy(className = "active_option")
    protected WebElement filterOptionActive;

    @FindBy(xpath = "//select[@class='product_sort_container']/option[@value='az']")
    protected WebElement filterOptionNameAtoZ;

    @FindBy(xpath = "//select[@class='product_sort_container']/option[@value='za']")
    protected WebElement filterOptionNameZtoA;

    @FindBy(xpath = "//select[@class='product_sort_container']/option[@value='lohi']")
    protected WebElement filterOptionPriceLowToHigh;

    @FindBy(xpath = "//select[@class='product_sort_container']/option[@value='hilo']")
    protected WebElement filterOptionPriceHighToLow;

    public InventoryPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
