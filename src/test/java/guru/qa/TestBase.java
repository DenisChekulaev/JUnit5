package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
    public class TestBase {
        @BeforeAll
        static void configure() {
            Configuration.holdBrowserOpen = true;
            Configuration.browser = "chrome";
            Configuration.browserSize = "1920x1000";
        }
    }

