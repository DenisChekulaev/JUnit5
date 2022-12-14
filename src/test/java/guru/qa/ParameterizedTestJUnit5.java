package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedTestJUnit5 extends TestBase {

    @ValueSource(strings = {"Днепровская роща", "Fresh"})
    @ParameterizedTest(name = "Проверка поиска ЖК {0}")
    void commonSearchTest(String testData) {
        open("https://o-z.broker/catalog");
        $("#mat-input-0").setValue(testData).pressEnter();
        $(".catalog-complex-card__name").shouldHave(text(testData));
    }

    @DisplayName("Проверка застройщика у ЖК")
    @CsvSource(value ={
            "Днепровская роща, Комстрой",
            "Fresh, АльфаСтройКомплекс",
    })
    @ParameterizedTest(name = "Проверка застройщика ЖК {0} результаты содержат текст {1}")
    void commonComplexSearchTest(String testData, String expectedResult) {
        open("https://o-z.broker/catalog");
        $("#mat-input-0").setValue(testData).pressEnter();
        $(".catalog-complex-card__developer").shouldHave(text(expectedResult));
    }
static Stream<Arguments> selenideSearchCityTest(){
        return Stream.of(
                Arguments.of("Ростов-на-Дону", List.of("г. Ростов-на-Дону")),
                    Arguments.of("Краснодар", List.of("г. Краснодар"))
        );
}
    @MethodSource("selenideSearchCityTest")
    @ParameterizedTest(name = "Для города {0} результат поиска {1}")
    void selenideSearchCityTest(String city, List<String> expectedResult){
        open("https://o-z.broker/catalog");
        $("#mat-chip-list-input-0").click();
        $$(".mat-checkbox-label").find((text(city))).click();
        $$(".g-catalog-complexes-list").shouldHave(CollectionCondition.texts(expectedResult));
    }
}
