package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    ShopPage shopPage = new ShopPage();

    @BeforeAll
    static void startMaximized() {
        Configuration.browserSize = "1920x1080";
    }
}
