package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

import java.io.IOException;
import java.util.logging.Logger;



public class Hooks {
    //private bcz i ll use it only in this class
    private AppiumDriverLocalService appiumServer;
    private AppiumServiceBuilder builder;

    final Runtime runtime = Runtime.getRuntime();

    @Before
    public void setUp() {
        //it starts appium server
        if (appiumServer != null) {
            appiumServer.stop();
            System.out.println("Kill nodes");
        }

        builder = new AppiumServiceBuilder();
        builder.withArgument(() -> "-pa", "/wd/hub");
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        appiumServer = AppiumDriverLocalService.buildService(builder);

        appiumServer.start();


    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }

        Driver.quitAppiumDriver();
        appiumServer.stop();

    }

    public void forceStopAppiumServer() {
        try {
            String[] command = {"taskkill", "/F", "/IM", "node"};
            runtime.exec(command);
            System.out.println("Kill all nodes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}