

package ExtentReport;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final String DATE_FORMAT = "yyyyMMddHHmmss";
    private static final String DATA_IMAGE_PNG_BASE_64 = "data:image/png;base64,";

    public static String getScreenshot(WebDriver driver) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        String stringDate = simpleDateFormat.format(date);
        String encodedBase64 = null;
        FileInputStream fileInputStream = null;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\Foldername\\target\\Extent-reports-Screenshots\\" + "Screenshot_" + stringDate + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileInputStream = new FileInputStream(finalDestination);
            byte[] bytes = new byte[(int) finalDestination.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DATA_IMAGE_PNG_BASE_64 + encodedBase64;
    }
    }
