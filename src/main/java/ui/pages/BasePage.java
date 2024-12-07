package ui.pages;

import actions.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.components.footer.Footer;
import ui.components.header.Header;
import ui.pages.itemPage.ItemPage;

public class BasePage extends PageActions {
    protected WebDriver driver;
    public Header header;
    public Footer footer;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new Header(driver);
        this.footer = new Footer(driver);
    }

    public int getItemId(WebElement inventoryItem) {
        try {
            WebElement itemLink = findElement(inventoryItem, By.cssSelector("a[id*='item_']"), "item link");
            String idValue = itemLink.getAttribute("id");
            String itemId = idValue.replaceAll("\\D+", "");
            return Integer.parseInt(itemId);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Item ID not found for the given inventory item.", e);
        }
    }

    public ItemPage openItemByTitle(WebElement item) {
        WebElement itemTitle = findElement(item, By.cssSelector("div[data-test='inventory-item-name']"), "item title");
        click(itemTitle, "item title");
        return new ItemPage(driver);
    }

    public ItemPage openItemByImage(WebElement itemImage) {
        click(itemImage, "item image");
        return new ItemPage(driver);
    }
}