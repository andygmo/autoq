package com.bbc.pageobjects.basepages;

import com.bbc.components.BbcHeader;
import com.sqs.web.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Will be used as a base page to page objects allowing extension of head and footer elements to
 * page objects.
 */
public abstract class BbcBasePage<TOriginPage> extends PageObjectBase<TOriginPage> {

    public BbcHeader<TOriginPage> BbcHeader = new BbcHeader<>(this);

    /**
     * Get the current page title
     * @return the page title label
     */
    @Step("The correct page title is displayed")
    public Label getPageTitleElement(){
        return new Label((By.xpath("//meta[@property='og:title']")));
    }


}
