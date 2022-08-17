package guru.qa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class WebTest extends TestBase {

        @DisplayName("Проверка поиска ЖК")
        @Test
        void selenideTest() {
            open("https://o-z.broker/catalog");
            $("#mat-input-0").setValue("Днепровская роща").pressEnter();
            $(".catalog-complex-card__name").shouldHave(text("Днепровская роща"));
        }

        @Disabled("ЖК продан, поиск неактуальный")
        @DisplayName("Test")
        @Test
        void selenideTest1() {
            open("https://o-z.broker/catalog");
            $("#mat-input-0").setValue("Самолет").pressEnter();
            $(".catalog-complex-card__name").shouldHave(text("Самолет"));
        }

    }

