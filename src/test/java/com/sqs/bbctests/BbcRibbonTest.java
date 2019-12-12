package com.sqs.bbctests;


import com.bbc.components.BbcHeader;
import com.bbc.components.BbcSearch;
import com.bbc.pageobjects.BbcHome;
import com.bbc.pageobjects.BbcNews;
import com.bbc.pageobjects.BbcSport;
import com.bbc.pageobjects.BbcWeather;
import com.sqs.bbctests.base.BbcBaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import com.bbc.utility.Screenshot;


public class BbcRibbonTest extends BbcBaseTest {

    @Test(description = "Check that we can hit the BBC News page")
    public void canNavigateToNews(){
        waitFor(BbcHome.class)
                .BbcHeader.goToNews()
                .assertThatElement("Check the page title is BBC-News", new BbcNews().getPageTitleElement().getAttribute("content"), is("Home - BBC News"));
    }

    @Test(description = "Check that we can hit the BBC Weather page")
    public void canNavigateToWeather(){
        waitFor(BbcHome.class)
                .BbcHeader.goToWeather()
                .assertThatElement("Check the Weather page title", new BbcWeather().getPageTitleElement().getAttribute("content"), is("BBC Weather"));
    }

    @Test(description = "Check that we can goto the BBC Sport page")
    public void canNavigateToSport(){
        waitFor(BbcHome.class)
                .BbcHeader.gotoSports()
                .assertThatElement("Check the Sport page title", new BbcSport().getPageTitleElement().getAttribute("content"), is("Home - BBC Sport"));
        //Screenshot ss = new Screenshot();
        //ru.yandex.qatools.ashot.Screenshot screenie = ss.takeScreenShot();
        //ss.saveScreenShot(screenie, "/tmp/result/", "test");
    }

    @Test(description = "Test that the search bar on the ribbon returns a result")
    public void checkTopSearchResultFromSmallBox(){
        waitFor(BbcHome.class)
                .BbcHeader.searchForTopic("Belfast")
                .assertThatElement("Top Search result from small search box contains Belfast", new BbcSport().BbcHeader.topSearchResult.getText(),is("Belfast"));
    }
}

