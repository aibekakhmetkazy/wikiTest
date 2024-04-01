import org.junit.Test;
import pages.BaseSearchPage;
import pages.SuggestedSearchPage;

public class TransitionToPageTest extends BaseTest {

    @Test
    public void testTransitionToPage() throws InterruptedException {

        String searchText = "Вконтакте";

        BaseSearchPage baseSearchPage = new BaseSearchPage();

        baseSearchPage.inputSearch(searchText);
        String firstSuggestion = baseSearchPage.FirstSuggestionText();
        baseSearchPage.clickToFirstSuggestion();

        SuggestedSearchPage suggestedSearchPage = new SuggestedSearchPage();

        suggestedSearchPage
                .assertEqualNames(firstSuggestion);

        System.out.println("Тест 2. Переход на страницу с таким же названием как в 1 саджесте пройден успешно");
    }
}
