package com.sqs.bbctests;

import com.bbc.components.BbcSearch;
import com.bbc.pageobjects.BbcHome;
import com.sqs.bbctests.base.BbcBaseTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class BbcSearchTests extends BbcBaseTest {
    @Test(description = "Check the search functionality")
    public void checkTopSearchResultFromSmallBox(){
        waitFor(BbcHome.class)
                .assertThatElement("Top Search result from small search box contains Belfast", new BbcSearch().searchForTopic("Belfast").topSearchResult.getText(),is("Belfast"));
    }

    @Test(description = "Check the search functionality")
    public void checkTopSearchResultFromLargeBox(){
        waitFor(BbcHome.class)
                .assertThatElement("Top Search result from large search box contains Belfast", new BbcSearch().largeBoxSearch("Belfast").topSearchResult.getText(),is("Belfast"));
    }
}
