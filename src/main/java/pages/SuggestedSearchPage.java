package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SuggestedSearchPage extends BasePage {

    @FindBy(css = ".mw-page-title-main")
    WebElement pageTitle;

    public SuggestedSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public SuggestedSearchPage assertEqualNames(String suggestedText) {
        assertEquals(suggestedText, pageTitle.getText());
        return this;
    }
}
