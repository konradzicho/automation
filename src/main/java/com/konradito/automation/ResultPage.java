package com.konradito.automation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage {

    @FindBy(id = "firstHeading")
    private WebElement firstHeading;

    public String getSourceOfFirstHeading() {
        return this.firstHeading.getText();
    }
}
