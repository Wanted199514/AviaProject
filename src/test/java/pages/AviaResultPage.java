package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AviaResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='ticket-desktop']")
    private List<WebElement> tickets;

    @FindBy(xpath = "//div[@class='ticket-desktop']")
    private WebElement oneTicket;

    public AviaResultPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public boolean aviaResultPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.aviasales.ru/search/");
    }

    public void waitTickets() {
        waitUntilElementIsAppear(oneTicket);
    }

    public int sumTickets() {
        return tickets.size();
    }
}
