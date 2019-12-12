package com.presta.pageobjects.basepages;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Base page object.
 */
public abstract class PageObjectBase<TOriginPage> {

  public PageObjectBase<TOriginPage> OriginPage;

  SoftAssert softAssertion = new SoftAssert();

  public <D extends PageObjectBase<D>> D navigatingTo(Class<D> originPage) {
    D newPage = null;
    try {
      newPage = originPage.newInstance();

    } catch (Exception ex) {

    }
    return newPage;
  }

  @Step("Asserting that element: {0}")
  public <T> void assertThatElement(String info, T actual, Matcher<? super T> matcher) {
    assertThat(info, actual, matcher);
  }

  @Step("Asserting that element: {0}")
  public TOriginPage softAssert(boolean assertion) {
    softAssertion.assertTrue(assertion);
    return (TOriginPage) this;
  }

  @Step("Asserting that {0} equals {1}")
  public TOriginPage softAssert(String expected, String actual) {
    softAssertion.assertEquals(expected, actual);
    return (TOriginPage) this;
  }

  @Step("Asserting that {0} equals {1}")
  public TOriginPage softAssert(int expected, int actual) {
    softAssertion.assertEquals(expected, actual);
    return (TOriginPage) this;
  }

  public void assertAll() {
    softAssertion.assertAll();
  }

}
