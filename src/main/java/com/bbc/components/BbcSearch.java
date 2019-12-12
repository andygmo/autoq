package com.bbc.components;

import com.bbc.pageobjects.basepages.PageObjectBase;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.TextInput;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BbcSearch<TOriginPage> extends PageObjectBase<TOriginPage> {

    private final TextInput smallSearchTextBox = new TextInput(By.id("orb-search-q"));
    private final TextInput largeSearchTextBox = new TextInput(By.id("se-searchbox-input-field"));
    private final Button searchButton = new Button(By.xpath("//*[@id='searchboxDrawerForm']/button[@type='submit']"));
    public Label topSearchResult = new Label(By.id("suggestion-0"));

    @Step("Search for text on BBC")
    public BbcSearch searchForTopic(String topic){
        this.smallSearchTextBox.clearText();
        this.smallSearchTextBox.setText(topic);
        return this;
    }

    @Step("Search using the large search ribbon")
    public BbcSearch largeBoxSearch(String topic){
        this.smallSearchTextBox.clearText();
        this.smallSearchTextBox.setText(" ");
        this.largeSearchTextBox.click();
        this.largeSearchTextBox.clearText();
        this.largeSearchTextBox.setText(topic);
        return this;
    }
}
