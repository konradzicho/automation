package com.konradito.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    @FindBy(css = ".central-textlogo img")
    private WebElement headlineLogo;

    @FindBy(id = "searchInput")
    private WebElement searchBar;

    @FindBy(css = "button.pure-button.pure-button-primary-progressive")
    private WebElement searchButton;

    public String getSourceOfHeadlineLogo() {
        return this.headlineLogo.getAttribute("src");
    }

    public void makeSearch(String phrase){
        searchBar.sendKeys(phrase);
        searchButton.click();
    }
}

