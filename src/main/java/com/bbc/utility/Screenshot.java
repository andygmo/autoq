package com.bbc.utility;

import com.sqs.core.common.logging.Logger;
import com.sqs.core.common.logging.LoggerProvider;
import com.sqs.web.webdriver.DriverProvider;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    
    private static final Logger logger = LoggerProvider.getLogger("ScreenShot");
    /**
     * Function to generate screen shot for comparisons
     */
    public void takeScreenShot(String savePath, String fileName) {
        logger.info("Snapping screenshot");
        ru.yandex.qatools.ashot.Screenshot screenshot = new AShot().takeScreenshot(DriverProvider.getDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG",
                    new File(savePath + "/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyScreenShot(BufferedImage baseShot, BufferedImage actualShot){
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualShot, baseShot).withDiffSizeTrigger(0);

        if (diff.hasDiff()) {
            logger.info("Difference on screen detected, writing difference image.");
            BufferedImage diffImg = diff.getMarkedImage();
            try {
                ImageIO.write(diffImg, "PNG", new File("/tmp/result/diff.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            logger.info("No differences detected in screen");
        }
        return diff.hasDiff();
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