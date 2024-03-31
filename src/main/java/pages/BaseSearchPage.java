package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseSearchPage extends BasePage {
    @FindBy(css = ".vector-search-box-input")
    private WebElement searchInput;

    @FindBy(css = ".searchButton")
    private WebElement findButton;

    @FindBy(xpath = "//*[@class=\"suggestions-result\"]//*[@class=\"highlight\"]")
    private List<WebElement> highlighted;

    @FindBy(xpath = "//*[@class=\"suggestions-result\"][@rel=\"0\"]")
    private WebElement findFirstSuggestion;

    @FindBy(xpath = "//*[@class=\"suggestions\"]//*[@class=\"suggestions-special\"]")
    private WebElement SpecialSuggestion;
//    WebElement elem = yourWebDriverInstance.findElement(By.xpath("//*[@class='goog-menu goog-menu-vertical uploadmenu density-tiny']/input"));
//    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
//    ((JavascriptExecutor) yourWebDriverInstance).executeScript(js, elem);

    public BaseSearchPage() {
        driver.get(config.baseUrl() + "/wiki/Заглавная_страница");
        PageFactory.initElements(driver, this);
    }

    public BaseSearchPage inputSearch(String searchText) throws InterruptedException {
        searchInput.click();
        sleep(200);
        searchInput.sendKeys(searchText);
        return this;
    }

    public BaseSearchPage clickFindButton() {
        findButton.click();
        return this;
    }

    public BaseSearchPage clickToFirstSuggestion() throws InterruptedException{
        findFirstSuggestion.click();
        sleep(2000);
        return this;
    }

    public String FirstSuggestionText() {
        return findFirstSuggestion.getText();
    }

    public BaseSearchPage clickToSpecialSuggestion() {
        SpecialSuggestion.click();
        return this;
    }

    public BaseSearchPage assertHighlightedTextValue(List<String> expectedHighlightedTextList) throws InterruptedException {
        for (int i = 0; i < highlighted.size(); i++) {
            assertEquals(expectedHighlightedTextList.get(i), highlighted.get(i).getText());
        }
        return this;
    }

    public BaseSearchPage assertTransitionToPage(int expectedHighlightedText) throws InterruptedException{
//        sleep(2000);
        assertEquals(expectedHighlightedText, highlighted.size());
        return this;
    }
}
