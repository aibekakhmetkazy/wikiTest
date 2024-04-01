import org.junit.Test;
import pages.BaseSearchPage;
import pages.SuggestedSearchPage;

public class PageTransitionFromButtonTest extends BaseTest {

    @Test
    public void testPageTransitionFromButton() throws InterruptedException {

        String searchText = "ВКонтакте";
        String ifNotSuggestedPageTitle = "Результаты поиска";
        BaseSearchPage baseSearchPage = new BaseSearchPage();

        baseSearchPage.inputSearch(searchText);
        String firstSuggestion = baseSearchPage.FirstSuggestionText();
        baseSearchPage.clickFindButton();

        SuggestedSearchPage suggestedSearchPage = new SuggestedSearchPage();

        if (firstSuggestion.equals(searchText)) {
            suggestedSearchPage
                    .assertEqualNames(searchText);
            System.out.println("Тест 3. Переход на страницу с таким же названием как в 1 саджесте после нажатия на кнопку поиска пройден успешно");
        } else {
            suggestedSearchPage
                    .assertPageTitle(ifNotSuggestedPageTitle);
            System.out.println("Тест 3. Переход на страницу поиска пройден успешно");
        }
    }
}
