import org.junit.Test;
import pages.BaseSearchPage;
import pages.SuggestedSearchPage;

public class SpecialSuggestionTest extends BaseTest {

    @Test
    public void testSpecialSuggestion() throws InterruptedException {

        String searchText = "Конт";
        String ifNotSuggestedPageTitle = "Результаты поиска";

        BaseSearchPage baseSearchPage = new BaseSearchPage();

        baseSearchPage
                .inputSearch(searchText)
                .clickToSpecialSuggestion();

        SuggestedSearchPage suggestedSearchPage = new SuggestedSearchPage();

        suggestedSearchPage
                .assertPageTitle(ifNotSuggestedPageTitle);

        System.out.println("Тест 4. Переход на страницу поиска из специального саджеста пройден успешно");
    }
}