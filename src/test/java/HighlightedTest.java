import org.junit.Test;
import pages.BaseSearchPage;

import java.util.ArrayList;
import java.util.List;

public class HighlightedTest extends BaseTest {

    @Test
    public void testHighlightedText() throws InterruptedException {

        String searchText = "ВКонтакте";
        List<String> highlightedTextList = new ArrayList<>();
        int expecteHighlightedText = 10;

        for (int i = 0; i < expecteHighlightedText; i++) {
            highlightedTextList.add(searchText);
        }

        BaseSearchPage baseSearchPage = new BaseSearchPage();

        baseSearchPage
                .inputSearch(searchText)
                .assertHighlightedTextValue(highlightedTextList);

        System.out.println("Тест 1. Поисковый запрос в саджестах выделяется жирным шрифтом");
    }
}
