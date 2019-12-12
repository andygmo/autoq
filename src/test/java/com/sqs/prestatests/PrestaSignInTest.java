package com.sqs.prestatests;


import com.presta.pageobjects.PrestaHome;
import com.sqs.prestatests.base.PrestaBaseTest;
import org.testng.annotations.Test;

/**
 * As a user I want to be able to log into the Presta shop.
 */
public class PrestaSignInTest extends PrestaBaseTest {

  // Sign in with valid details
  @Test(groups = "PrestaSignInTests")
  public void prestaSignInValidTest() {
    waitFor(PrestaHome.class);
  }


}
