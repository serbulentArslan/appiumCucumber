package utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class Driver {

    private static AndroidDriver<MobileElement> appiumDriver;

    public static AndroidDriver<MobileElement> getAppiumDriver() {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
        caps.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");

        try {
            appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return appiumDriver;
    }


    public static void quitAppiumDriver() {
        appiumDriver.quit();
        appiumDriver = null;

    }
}

/*
private AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildService(
            new AppiumServiceBuilder()
                    .withArgument(() -> "-pa", "/wd/hub"));


                    String[] command = {"taskkill", "/F", "/IM", "node"};
            runtime.exec(command);
            System.out.println("Kill all nodes");
 */