package com.bbc.components;


import com.bbc.pageobjects.BbcNews;
import com.bbc.pageobjects.BbcSport;
import com.bbc.pageobjects.BbcWeather;
import com.bbc.pageobjects.basepages.PageObjectBase;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.TextInput;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * The Bbc header.
 */

public class BbcHeader<TOriginPage> extends PageObjectBase<TOriginPage> {


    private final Hyperlink news = new Hyperlink(By.xpath("//*[@class='orb-nav-news']/a"));
    private final Hyperlink sport = new Hyperlink(By.xpath("//*[@class='orb-nav-sport']/a"));
    private final Hyperlink weather = new Hyperlink(By.xpath("//*[@class='orb-nav-weather']/a"));
    //private final Hyperlink iPlayer = new Hyperlink(By.xpath("//*[@class='orb-nav-iplayer']/a"));
    //private final Hyperlink sounds = new Hyperlink(By.xpath("//*[@class='orb-nav-sounds']/a"));
    //private final Hyperlink more = new Hyperlink(By.xpath("//*[@id='orb-nav-more']/a"));
    private final TextInput smallSearchTextBox = new TextInput(By.id("orb-search-q"));
    //private final TextInput largeSearchTextBox = new TextInput(By.id("se-searchbox-input-field"));
    //private final Button searchButton = new Button(By.xpath("//*[@id='searchboxDrawerForm']/button[@type='submit']"));
    public final Label topSearchResult = new Label(By.id("suggestion-0"));

    PageObjectBase<TOriginPage> page;

    public BbcHeader(PageObjectBase<TOriginPage> originPage) {
        this.page = originPage;
        OriginPage = originPage;
    }

    /**
     * Click the News link
     *
     * @return the news page
     */
    @Step("Click the news link")
    public BbcNews goToNews(){
        news.click();
        return navigatingTo(BbcNews.class);
    }

    @Step("Click the weather link")
    public BbcWeather goToWeather(){
        weather.click();
        return navigatingTo(BbcWeather.class);
    }

    @Step("Click the sports link")
    public BbcSport gotoSports(){
        sport.click();
        return navigatingTo(BbcSport.class);
    }
    @Step("Search for text on BBC")
    public TOriginPage searchForTopic(String topic){
        this.smallSearchTextBox.clearText();
        this.smallSearchTextBox.setText(topic);
        return (TOriginPage) page;
    }
}
