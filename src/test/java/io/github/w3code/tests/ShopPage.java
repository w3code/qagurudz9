package io.github.w3code.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ShopPage {
    //locators and elements
    private SelenideElement
            searchField = $("#gh-ac"),
            searchButton = $("#gh-btn");

    private ElementsCollection
            goodItem = $$(".s-item__info");

    //actions
    public ShopPage openPage() {
        open("https://www.ebay.com/");
        return this;
    }

    public ShopPage fillSearchField(String value) {
        searchField.setValue(value);
        return this;
    }

    public ShopPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public void checkResultsValue(String expectedValue) {
        goodItem.filterBy(text(expectedValue)).shouldHave(sizeGreaterThanOrEqual(1));
    }
}
