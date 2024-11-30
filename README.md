## SwagLabs UI Tests

**Fluent UI tests using Java, TestNG, JUnit, Selenium, well-structured modular design with reusable components, detailed logging and clean exceptions.**

---

## Source Folder Structure

```plaintext
└─ src
   ├─ main
   │  └─ java
   │     ├─ actions
   │     │  └─ PageActions.java
   │     ├─ config
   │     │  └─ Config.java
   │     ├─ factory
   │     │  └─ BrowserFactory.java
   │     ├─ listener
   │     │  └─ TestListener.java
   │     └─ ui
   │        ├─ components
   │        │  ├─ footer
   │        │  │  ├─ Footer.java
   │        │  │  └─ FooterElements.java
   │        │  ├─ header
   │        │  │  ├─ Header.java
   │        │  │  └─ HeaderElements.java
   │        │  └─ BaseComponent.java
   │        └─ pages
   │           ├─ cartPage
   │           │  ├─ CartPage.java
   │           │  └─ CartPageElements.java
   │           ├─ checkoutCompletePage
   │           │  ├─ CheckoutCompletePage.java
   │           │  └─ CheckoutCompletePageElements.java
   │           ├─ checkoutStepOnePage
   │           │  ├─ CheckoutStepOnePage.java
   │           │  └─ CheckoutStepOnePageElements.java
   │           ├─ checkoutStepTwoPage
   │           │  ├─ CheckoutStepTwoPage.java
   │           │  └─ CheckoutStepTwoPageElements.java
   │           ├─ inventoryPage
   │           │  ├─ InventoryPage.java
   │           │  └─ InventoryPageElements.java
   │           ├─ itemPage
   │           │  ├─ ItemPage.java
   │           │  └─ ItemPageElements.java
   │           ├─ loginPage
   │           │  ├─ LoginPage.java
   │           │  └─ LoginPageElements.java
   │           └─ BasePage.java
   └─ test
      ├─ java
      │  └─ swaglabs
      │     ├─ constants
      │     │  ├─ Credentials.java
      │     │  ├─ ErrorType.java
      │     │  ├─ InputDetails.java
      │     │  └─ PageUrl.java
      │     ├─ dataproviders
      │     │  └─ LoginTestDataProvider.java
      │     ├─ facades
      │     │  ├─ FooterFacade.java
      │     │  ├─ HeaderFacade.java
      │     │  ├─ InventoryFacade.java
      │     │  └─ LoginFacade.java
      │     ├─ tests
      │     │  └─ page
      │     │     ├─ BaseTest.java
      │     │     ├─ FooterTest.java
      │     │     ├─ HeaderTest.java
      │     │     └─ LoginTest.java
      │     ├─ utils
      │     │  ├─ CustomAssert.java
      │     │  ├─ CustomSoftAssert.java
      │     │  └─ RandomStringGenerator.java
      └─ resources
         ├─ config.properties
         └─ logback.xml
```
