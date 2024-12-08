# SwagLabs UI Tests

**Artur Lasimer arlasi@taltech.ee**

Fluent UI tests using Java, TestNG, Selenium, Maven, well-structured modular design with reusable components, detailed logging and clean exceptions.

---

## Prerequisites

Ensure the following software is installed on your system:

- **Apache Maven 3.9.6**
- **Java 21**
- **Google Chrome** or **Mozilla Firefox**

---

## Configuration

All configurations are managed in the `config.properties` file located under the `src/test/resources` folder.


```properties
browser=CHROME                          # CHROME/FIREFOX. Specifies the browser for test execution.
headless=false                          # true/false. Determines whether the tests run in headless mode (no UI)
implicit.wait.time=6                    # Implicit wait in seconds
page.load.timeout=6                     # Page load timeout in seconds
base.url=https://www.saucedemo.com/     # Starting URL for test execution
```

---

## How to Run

1. **Clone this repository to your local machine**:
   ```bash
   git clone https://github.com/arlas1/swaglabs-ui-tests

2. **Navigate to the project root folder**:
   ```bash
   cd swaglabs-ui-tests

3. **Ensure Apache Maven is installed and added to your system's PATH**


4. **Execute the following command to clean the project and run the tests**:
   ```bash
   mvn clean test

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
      │     │  ├─ ErrorMessage.java
      │     │  ├─ InputDetails.java
      │     │  ├─ PageUrl.java      
      │     │  └─ SortType.java
      │     ├─ dataproviders
      │     │  └─ TestDataProvider.java
      │     ├─ facades
      │     │  ├─ CartFacade.java
      │     │  ├─ CheckoutCompleteFacade.java
      │     │  ├─ CheckoutStepOneFacade.java      
      │     │  ├─ CheckoutStepTwoFacade.java
      │     │  ├─ FooterFacade.java
      │     │  ├─ HeaderFacade.java
      │     │  ├─ InventoryFacade.java
      │     │  ├─ ItemFacade.java
      │     │  └─ LoginFacade.java
      │     ├─ tests
      │     │  ├─ setup
      │     │  │  └─SetUp.java
      │     │  └─ page
      │     │     ├─ BaseTest.java
      │     │     ├─ CartTest.java
      │     │     ├─ CheckoutCompleteTest.java
      │     │     ├─ CheckoutStepOneTest.java
      │     │     ├─ CheckoutStepTwoTest.java
      │     │     ├─ FooterTest.java
      │     │     ├─ HeaderTest.java
      │     │     ├─ InventoryTest.java
      │     │     ├─ HeaderTest.java
      │     │     └─ LoginTest.java
      │     ├─ utils
      │     │  ├─ CustomAssert.java
      │     │  ├─ CustomSoftAssert.java
      │     │  └─ RandomStringGenerator.java
      └─ resources
         ├─ config.properties
         ├─ logback.xml
         └─ testng.xml
```
