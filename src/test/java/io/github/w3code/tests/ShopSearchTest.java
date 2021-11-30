package io.github.w3code.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class ShopSearchTest extends TestBase {


    //some npocbet's comments 4 9th homework
    @EnumSource(ToolItems.class)
    @Tag("Blocker")
    @DisplayName("Power Tools search")
    @ParameterizedTest(name = "Search {0} item")
    void goodSearchTest_EnumSource(ToolItems toolItems) {
        shopPage
                .openPage()
                .fillSearchField(toolItems.getBrand())
                .clickSearchButton()
                .checkResultsValue(toolItems.getTitle());
    }

    static Stream<Arguments> goodSearchTest_MethodSource() {
        return Stream.of(
                Arguments.of("DeWALT DCS551B", List.of("DeWALT DCS551B 20V 20 Volt Li-Ion Max Cordless Rotary Drywall Cut-out Tool")),
                Arguments.of("Milwaukee 2810-20", List.of("Milwaukee 2810-20 M18 18V 18 Volt FUEL Mud Mixer")),
                Arguments.of("Makita XWT15Z", List.of("Makita XWT15Z 18V LXT Lithium?Ion Brushless Cordless"))
        );
    }

    @Disabled
    @MethodSource
    @Tag("Blocker")
    @DisplayName("Power Tools search")
    @ParameterizedTest(name = "Search {0} item contains \"{1}\" title")
    void goodSearchTest_MethodSource(String toolItem, List<String> toolItemTitle) {
        shopPage
                .openPage()
                .fillSearchField(toolItem)
                .clickSearchButton()
                .checkResultsValue(toolItemTitle.get(0));
    }

    @Disabled
    @CsvFileSource(resources = "/source.csv")
    @Tag("Blocker")
    @DisplayName("Power Tools search")
    @ParameterizedTest(name = "Search {0} item contains \"{1}\" title")
    void goodSearchTest_CsvFileSource(String toolItem, String toolItemTitle) {
        shopPage
                .openPage()
                .fillSearchField(toolItem)
                .clickSearchButton()
                .checkResultsValue(toolItemTitle);
    }

    @Disabled
    @CsvSource(value = {
            "dewalt dcd791b|DEWALT DCD791B 20V 20 Volt 2 Speed Brushless",
            "Milwaukee 2407-20|Milwaukee 2407-20 NEW M12 12V Li-Ion Cordless",
            "Makita DHP482Z|Makita DHP482Z 18V LXT Combi Hammer Driver Drill"},
            delimiter = '|')
    @Tag("Blocker")
    @DisplayName("Power Tools search")
    @ParameterizedTest(name = "Search {0} item contains \"{1}\" title")
    void goodSearchTest_CsvSource(String toolItem, String toolItemTitle) {
        shopPage
                .openPage()
                .fillSearchField(toolItem)
                .clickSearchButton()
                .checkResultsValue(toolItemTitle);
    }

    @ValueSource(strings = {"DeWALT DCS551B", "Milwaukee 2810-20", "Makita XWT15Z"})
    @Tag("Blocker")
    @DisplayName("Power Tools search")
    @ParameterizedTest(name = "Search result contains {0}")
    void goodSearchTest_ValueSource(String toolItem) {
        shopPage
                .openPage()
                .fillSearchField(toolItem)
                .clickSearchButton()
                .checkResultsValue(toolItem);
    }
}
