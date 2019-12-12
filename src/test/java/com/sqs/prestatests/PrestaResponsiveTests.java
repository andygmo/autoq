package com.sqs.prestatests;
        import com.presta.pageobjects.basepages.PrestaBasePage;
        import com.presta.utility.Screenshot;
        import com.presta.common.TestListener;
        import com.presta.enums.ErrorMessages;
        import com.presta.pageobjects.PrestaCreateNewAccountPage;
        import com.presta.pageobjects.PrestaHome;
        import com.sqs.core.common.Config;
        import com.sqs.prestatests.base.PrestaBaseTest;
        import org.apache.xpath.operations.Bool;
        import org.junit.Assert;
        import org.testng.annotations.*;



        import java.io.File;

        import static org.hamcrest.CoreMatchers.is;


public class PrestaResponsiveTests extends PrestaBaseTest {

    @Test(description = "Verify the SignIn Page")
    @Parameters({"device"})
    public void checkSignInPageResponsiveDesign(@Optional("iPad") String device){
        waitFor(PrestaHome.class).PrestaHeader.navigateToPrestaSignIn();
        Screenshot ss = new Screenshot();
        ss.takeScreenShot(Config.getGlobalProperty("snapDir"),"SignInactual_" + device, true, true);
        Assert.assertTrue(ss.verifyScreenShot(Config.getGlobalProperty("baseLineDir") + "SignInbase_" + device + ".png", Config.getGlobalProperty("snapDir") +"SignInactual_" + device + ".png"));
    }


    @Test(description = "Verify the Contact Us Page")
    @Parameters({"device"})
    public void checkProductPageResponsiveDesign(@Optional("iPad") String device){
        waitFor(PrestaHome.class).PrestaHeader.navigateToPrestaContactUs();
        Screenshot ss = new Screenshot();
        ss.takeScreenShot(Config.getGlobalProperty("snapDir"),"ContactUsactual_" + device, true, true);
        Assert.assertTrue(ss.verifyScreenShot(Config.getGlobalProperty("baseLineDir") + "ContactUsbase_" + device +".png", Config.getGlobalProperty("snapDir") + "ContactUsactual_" + device + ".png"));
    }

    @Test(description = "Verify the Create New Account Page")
    @Parameters({"device"})
    public void checkCreateNewAccountPageResponsiveDesign(@Optional("iPad") String device){
        waitFor(PrestaHome.class).PrestaHeader.navigateToPrestaSignIn().navigateToCreateNewAccount();
        Screenshot ss = new Screenshot();
        ss.takeScreenShot(Config.getGlobalProperty("snapDir"),"CreateNewAccountPage_actual_" + device, true, true);
        Assert.assertTrue(ss.verifyScreenShot(Config.getGlobalProperty("baseLineDir") + "CreateNewAccountPage_base_" + device +".png", Config.getGlobalProperty("snapDir") + "CreateNewAccountPage_actual_" + device + ".png"));
    }
}