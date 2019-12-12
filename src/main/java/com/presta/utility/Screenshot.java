package com.presta.utility;

import com.sqs.core.common.logging.Logger;
import com.sqs.core.common.logging.LoggerProvider;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

public class Screenshot {
    
    private static final Logger logger = LoggerProvider.getLogger("ScreenShot");
    /**
     * Function to generate screen shot for comparisons
     */
    public void takeScreenShot(String savePath, String fileName, Boolean isFull, Boolean isRetina) {
        logger.info("Snapping screenshot");
        ru.yandex.qatools.ashot.Screenshot screenshot;
        WebDriver ssdriver = DriverProvider.getDriver();

        //Hide the scrollbar for screenshot
        ((JavascriptExecutor) ssdriver).executeScript("document.body.style.overflow = 'hidden';");

        //Full screen, no Retina
        if (isFull && !isRetina){
            screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(ssdriver);
        }
        //Full screen & retina
        else if (isFull && isRetina){
            screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2)).takeScreenshot(ssdriver);
        }
        //Viewport only
        else {
            screenshot = new AShot().takeScreenshot(ssdriver);
        }

        //Re-enable the scrollbar
        ((JavascriptExecutor) ssdriver).executeScript("document.body.style.overflow = 'visible';");
        try {
            ImageIO.write(screenshot.getImage(), "PNG",
                    new File(savePath + "/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean verifyScreenShot(String baseFile, String actualFile){
        //Get the images we want to compare:
        Screenshot imgHandler = new Screenshot();
        BufferedImage baseShot = imgHandler.openImage(baseFile);
        BufferedImage actualShot = imgHandler.openImage(actualFile);

        //Compare the images
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualShot, baseShot).withDiffSizeTrigger(0);

        //If there are differences, write them to an image file
        if (diff.hasDiff()) {
            String diffFile = "/tmp/result/diff.png";
            logger.info("Difference on screen detected, writing difference image: " + diffFile);
            BufferedImage diffImg = diff.getMarkedImage();
            try {
                ImageIO.write(diffImg, "PNG", new File(diffFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            logger.info("No differences detected in Screen image comparison");
        }
        //Return the inverse of hasDiffs so we can assertTrue later
        return !diff.hasDiff();
    }

    public BufferedImage openImage(String image){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(image));
        }catch (IOException e){
            e.printStackTrace();
        }
        return img;
    }
}