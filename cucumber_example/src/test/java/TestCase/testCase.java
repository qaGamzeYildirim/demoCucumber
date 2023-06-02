package TestCase;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
;

import static java.util.concurrent.TimeUnit.SECONDS;

public class testCase {
    WebDriver driver;
    WebDriverWait wait;


    @Given("Homepage loads")
    public void homePage() {
        String selectBrowser = "chrome";
        int timeout = 30;
        String url = "https://www.demoblaze.com/";
        if ("chrome".equalsIgnoreCase(selectBrowser)) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver.manage().timeouts().implicitlyWait(timeout, SECONDS);
            driver.get(url);


        } else if ("firefox".equalsIgnoreCase(selectBrowser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(timeout, SECONDS);
            driver.get(url);


        }
    }


    @When("The user clicks by id (.*)")
    public void theUserClicksById(String str2) {
        By element = By.id(str2);
        click(element);
    }

    @When("The user clicks by id on sign in modal (.*)")
    public void theUserClicksByIdOnSignInModal(String str2) {
        WebElement signInContent = findElement(By.cssSelector("#signInModal .modal-dialog"));
        By element = By.id(str2);
        clickOnTheModal(signInContent, element);
    }

    @When("Click by xpath on sign in modal (.*)")
    public void theUserClicksSignInByXpath(String str2) {
        WebElement signInContent = findElement(By.cssSelector("#signInModal .modal-dialog"));
        By element = By.xpath(str2);
        clickOnTheModal(signInContent, element);
    }

    @When("Click by xpath on login modal (.*)")
    public void theUserClicksLoginByXpath(String str2) {
        WebElement loginContent = findElement(By.cssSelector("#logInModal .modal-dialog"));
        By element = By.xpath(str2);
        clickOnTheModal(loginContent, element);
    }

    @When("The user clicks by xpath (.*)")
    public void theUserClicksByXpath(String str2) {
        By element = By.xpath(str2);
        click(element);
    }

    @When("The user clicks by cssSelector (.*)")
    public void theUserClicksByCssSelector(String str2) {
        By element = By.cssSelector(str2);
        click(element);
    }


    @When("The user compares object with text by id (.*) (.*) (.*)")
    public void theUserComparesWithId(String str1, String str2, String str3) {
        By element = By.id(str1);
        assert1(element, str2 + " " + str3);
    }


    @When("The user compares object with text by cssSelector (.*) (.*)")
    public void theUserComparesWithCssSelector(String str1, String str) {
        By element = By.cssSelector(str1);
        assert1(element, str);
    }

    @When("The user compares object with text by xpath (.*) (.*)")
    public void theUserComparesWithXpath(String str1, String str) {
        By element = By.xpath(str1);
        assert1(element, str);
    }

    @When("The user compares object with text by only xpath for product description (.*)")
    public void theUserComparesWithOnlyXpath(String str) {
        By element = By.xpath(str);
        assert1(element, "The HTC One M9 is powered by 1.5GHz octa-core Qualcomm Snapdragon 810 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage that can be expanded up to 128GB via a microSD card.");
    }

    @When("The user compares object with text by only cssSelector for purchase (.*)")
    public void theUserComparesWithOnlySelectorForPurchase(String str) {
        By element = By.cssSelector(str);
        assert1(element, "Thank you for your purchase!");
    }

    @When("The user compares object with three text by xpath (.*) (.*) (.*) (.*)")
    public void theUserComparesThreeTextWithXpath(String str1, String str2, String str3, String str4) {
        By element = By.xpath(str1);
        assert1(element, str2 + " " + str3 + " " + str4);
    }

    @When("The user compares to contains object with text by xpath (.*) (.*)")
    public void theUserComparesToContainsTextWithXpath(String str1, String str2) {
        By element = By.xpath(str1);
        assertContains(element, str2);
    }


    @Then("The user sees successful popup (.*)")
    public void successPopup(String str) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertTrue(alert.getText().contains(str));
        } catch (Exception e) {

        }

    }

    @When("The user writes by id (.*) (.*)")
    public void writeById(String str1, String str2) {
        By element = By.id(str1);
        findElement(element).sendKeys(str2);
    }

    @When("Write by id on the sign in modal (.*) (.*)")
    public void writeByIdSignInOnTheModal(String str1, String str2) {
        WebElement signInContent = findElement(By.cssSelector("#signInModal .modal-dialog"));
        By element = By.id(str1);
        signInContent.findElement(element).sendKeys(str2);
    }

    @When("Write by id on the login modal (.*) (.*)")
    public void writeByIdLoginOnTheModal(String str1, String str2) {
        WebElement loginContent = findElement(By.cssSelector("#logInModal .modal-dialog"));
        By element = By.id(str1);
        loginContent.findElement(element).sendKeys(str2);
    }

    @When("The user writes by cssSelector (.*) (.*)")
    public void writeByCssSelector(String str1, String str2) {
        By element = By.cssSelector(str1);
        findElement(element).sendKeys(str2);
    }

    @When("The user writes by xpath (.*) (.*)")
    public void writeByXpath(String str1, String str2) {
        By element = By.xpath(str1);
        findElement(element).sendKeys(str2);
    }


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void click(By by) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).isDisplayed();
        findElement(by).click();
        System.out.println(by + " ögesine tıklandı.");
    }

    public void clickOnTheModal(WebElement modal, By by) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).isDisplayed();
        modal.findElement(by).click();
        System.out.println(by + " ögesine tıklandı.");
    }


    public void assert1(By by, String strng) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        Assert.assertEquals(strng, element.getText());
    }

    public void assertContains(By by, String strng) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        Assert.assertTrue(element.getText().contains(strng));

    }


}
