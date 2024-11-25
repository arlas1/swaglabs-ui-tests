## UI Tests

 **SwagLabs automated tests + testing framework.**

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
      │     │  ├─ ErrorConstants.java
      │     │  ├─ InputConstants.java
      │     │  └─ RedirectLinks.java
      │     ├─ dataproviders
      │     │  └─ LoginTestDataProvider.java
      │     ├─ facades
      │     │  └─ LoginFacade.java
      │     ├─ tests
      │     │  └─ page
      │     │     ├─ BaseTest.java
      │     │     └─ LoginTest.java
      │     ├─ utils
      │     │  ├─ CustomAssert.java
      │     │  ├─ CustomSoftAssert.java
      │     │  └─ RandomStringGenerator.java
      └─ resources
         ├─ config.properties
         └─ logback.xml
```
