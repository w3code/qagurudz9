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
                Arguments.of("dewalt dcd791b", List.of("DEWALT DCD791B 20V 20 Volt 2 Speed Brushless")),
                Arguments.of("Milwaukee 2407-20", List.of("Milwaukee 2407-20 NEW M12 12V Li-Ion Cordless")),
                Arguments.of("Makita DHP482Z", List.of("Makita DHP482Z 18V LXT Combi Hammer Driver Drill"))
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

    @Disabled
    @ValueSource(strings = {"dewalt dcd791b", "Milwaukee 2407-20", "Makita DHP482Z"})
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
