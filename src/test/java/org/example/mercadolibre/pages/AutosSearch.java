package org.example.mercadolibre.pages;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.invoke.MethodHandles;

public class AutosSearch extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = ".ui-search-search-result__quantity-results")
    private WebElement quantityResult;

    @FindBy(name = "Maximum")
    private WebElement maxPrice;

    @FindBy(className = "ui-search-price-filter-action-btn")
    private WebElement priceFilterButton;

    @FindBy(css = ".ui-search-sort-filter .andes-dropdown__trigger")
    private WebElement sortFilter;
    @FindBy(id = "cb1-edit")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/section[2]/div[3]/ul/li[5]")
    private WebElement locations;
    public String getQuantityResult() {
        return action.getText(quantityResult);
    }

    public void setMaxPrice(final String price) {
        action.scrollTo(maxPrice);
        action.hover(maxPrice);
        action.setValue(maxPrice, price);
        action.click(priceFilterButton);
    }

    public void selectLocation(final String location) {
        LOGGER.info(() -> "Number of results : " + String.format("//span[contains(text(),'%s')]", location));
        action.scrollTo(locations);
        action.click(By.xpath(String.format("//span[contains(text(),'%s')]", location)));
    }

    public void sortBy(final String sortOrder) {
        action.click(sortFilter);
        action.click(By.xpath(String.format("//span[contains(text(),'Menor precio')]", sortOrder)));
    }
    public void searchVehicle(final String vehicle){
        action.setValue(searchBox, vehicle);
    }
}
