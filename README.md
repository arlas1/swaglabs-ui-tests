
## UI Tests

 **Testing framework + automated tests for SwagLabs.**

---

## Source Folder Structure

```plaintext
└─ src
   ├─ main
   │  └─ java
   │     ├─ actions
   │     │  └─ CustomActions.java
   │     ├─ config
   │     │  └─ Config.java
   │     ├─ factory
   │     │  └─ BrowserFactory.java
   │     ├─ listener
   │     │  └─ TestListener.java
   │     └─ ui
   │        ├─ component
   │        │  ├─ footer
   │        │  │  ├─ Footer.java
   │        │  │  └─ FooterElements.java
   │        │  ├─ header
   │        │  │  ├─ Header.java
   │        │  │  └─ HeaderElements.java
   │        │  └─ BaseComponent.java
   │        └─ page
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
   │           └─ loginPage
   │              ├─ LoginPage.java
   │              ├─ LoginPageElements.java
   │              └─ BasePage.java
   └─ test
      ├─ java
      │  └─ swaglabs
      │     ├─ facade
      │     │  └─ LoginFacade.java
      │     ├─ test
      │     │  └─ page
      │     │     ├─ BaseTest.java
      │     │     └─ LoginTest.java
      │     ├─ utils
      │     │  ├─ common
      │     │  │  ├─ RandomStringGenerator.java
      │     │  │  └─ RedirectLinks.java
      │     │  └─ test
      │     │     ├─ CustomAssert.java
      │     │     └─ CustomSoftAssert.java
      └─ resources
         ├─ config.properties
         └─ logback.xml
```
