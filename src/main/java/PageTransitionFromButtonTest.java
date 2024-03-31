import org.junit.Test;
import pages.BaseSearchPage;
import pages.SuggestedSearchPage;

public class PageTransitionFromButtonTest extends BaseTest {

    @Test
    public void testHighlightedTextNumber() throws InterruptedException {

        String searchText = "Вконтактеее";

        BaseSearchPage baseSearchPage = new BaseSearchPage();

        baseSearchPage.inputSearch(searchText);
        String firstSuggestion = baseSearchPage.FirstSuggestionText();
//        System.out.println(firstSuggestion);
        baseSearchPage.clickFindButton();

        SuggestedSearchPage suggestedSearchPage = new SuggestedSearchPage();

        suggestedSearchPage
                .assertEqualNames(firstSuggestion);

        System.out.println("Тест 3. Переход на страницу с таким же названием как в 1 саджесте после нажатия на кнопку поиска пройден успешно");
    }
}
