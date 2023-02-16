package org.example.mercadolibre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

public class CarsCategory extends AbstractPage {

    @FindBy(xpath = "//button[contains(@class, 'andes-button')]")
    private WebElement searchButton;

    @FindBy(id = "cb1-edit")
    private WebElement searchBox;
    public AutosSearch clickSearchButton() {
        action.hover(searchButton);
        action.click(searchButton);
        return new AutosSearch();
    }

    public AutosSearch setSearchBox(final String search){
        action.hover(searchBox);
        action.click(searchBox);
        action.setValue(searchBox, search);
        return new AutosSearch();
    }
}
