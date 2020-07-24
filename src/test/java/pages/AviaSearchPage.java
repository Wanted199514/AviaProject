package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class AviaSearchPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Откуда']")
    private WebElement fromWhereField;

    @FindBy(xpath = "//input[@placeholder='Куда']")
    private WebElement whereField;

    @FindBy(xpath = "//div[@class='trip-duration__input-wrapper --departure']")
    private WebElement thereField;

    @FindBy(xpath = "//div[@class='trip-duration__input-wrapper --return']")
    private WebElement backField;

    @FindBy(xpath = "//div[@aria-label='Sun Aug 30 2020']")
    private WebElement firstDate;

    @FindBy(xpath = "//div[@aria-label='Mon Aug 31 2020']")
    private WebElement secondDate;

    @FindBy(xpath = "//span[@class='form-submit__plane']")
    private WebElement findTicketsButton;

    public AviaSearchPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public void openAviaSearchPage() {
        webDriver.get("https://www.aviasales.ru/");
    }

    public boolean aviaSearchPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.aviasales.ru/");
    }

    public void inputData() {
        fromWhereField.click();
        fromWhereField.sendKeys("Париж");
        fromWhereField.sendKeys(Keys.ENTER);
        whereField.click();
        whereField.sendKeys("Лос-Анджелес");
        whereField.sendKeys(Keys.ENTER);
        thereField.click();
        waitUntilElementIsAppear(firstDate);
        firstDate.click();
        secondDate.click();
    }

    public void clickOnFindTicketsButton() {
        findTicketsButton.click();
    }

    public AviaResultPage changeTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.close();
        webDriver.switchTo().window(tabs2.get(1));
        return new AviaResultPage(webDriver);
    }
}
