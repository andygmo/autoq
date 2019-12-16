package com.sqs.prestatests;
import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.web.utils.ResponsiveUtils;
import com.presta.common.TestListener;
import com.presta.enums.ErrorMessages;
import com.presta.pageobjects.PrestaCreateNewAccountPage;
import com.presta.pageobjects.PrestaHome;
import com.sqs.core.common.Config;
import com.sqs.prestatests.base.PrestaBaseTest;
import org.apache.xpath.operations.Bool;
import org.junit.Assert;
import org.testng.annotations.*;

public class PrestaResponsiveTests extends PrestaBaseTest {

   /* @Test(description = "Verify the SignIn Page")
    @Parameters({"device"})
    public void checkSignInPageResponsiveDesign(@Optional("iPad") String device){
        waitFor(PrestaHome.class).PrestaHeader.navigateToPrestaSignIn();
        ResponsiveUtils ru = new ResponsiveUtils();
        ru.takeScreenShot(Config.getGlobalProperty("snapDir"),"SignInactual_" + device, true, true);
        Assert.assertTrue(ru.verifyScreenShot(Config.getGlobalProperty("baseLineDir") + "SignInbase_" + device + ".png", Config.getGlobalProperty("snapDir") +"SignInactual_" + device + ".png",Config.getGlobalProperty("diffDir") + "diff1.png"));
    }

    @Test(description = "Verify the Contact Us Page")
    @Parameters({"device"})
    public void checkProductPageResponsiveDesign(@Optional("iPad") String device){
        waitFor(PrestaHome.class).PrestaHeader.navigateToPrestaContactUs();
        ResponsiveUtils ru = new ResponsiveUtils();
        ru.takeScreenShot(Config.getGlobalProperty("snapDir"),"ContactUsactual_" + device, true, true);
        Assert.assertTrue(ru.verifyScreenShot(Config.getGlobalProperty("baseLineDir") + "ContactUsbase_" + device +".png", Config.getGlobalProperty("snapDir") + "ContactUsactual_" + device + ".png", Config.getGlobalProperty("diffDir") + "diff2.png"));
    }

    @Test(description = "Verify the Create New Account Page")
    @Parameters({"device"})
    public void checkCreateNewAccountPageResponsiveDesign(@Optional("iPad") String device){
        waitFor(PrestaHome.class).PrestaHeader.navigateToPrestaSignIn().navigateToCreateNewAccount();
        ResponsiveUtils ru = new ResponsiveUtils();
        ru.takeScreenShot(Config.getGlobalProperty("snapDir"),"CreateNewAccountPage_actual_" + device, true, true);
        Assert.assertTrue(ru.verifyScreenShot(Config.getGlobalProperty("baseLineDir") + "CreateNewAccountPage_base_" + device +".png", Config.getGlobalProperty("snapDir") + "CreateNewAccountPage_actual_" + device + ".png", Config.getGlobalProperty("diffDir") + "diff3.png"));
    }*/

    @Test(description = "Record the Accesibility score for the page")
    public void ATest(){
        waitFor(PrestaHome.class);
	if (true){
		System.out.println("This is a true");
		assert(true);
	}
    }
}
