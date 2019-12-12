package com.bbc.pageobjects;

import com.bbc.pageobjects.basepages.BbcBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;

/**
 * The BBC home page.
 */
public class BbcHome extends BbcBasePage<BbcHome> {

    private final Hyperlink prestaLogo = new Hyperlink(By.xpath("//*[@id='_desktop_logo']/a/img"));

    /**
     * Instantiates a new Presta home.
     */
    public BbcHome() {
        DriverProvider.getDriver().get(Config.getGlobalProperty("url"));

    }

}
