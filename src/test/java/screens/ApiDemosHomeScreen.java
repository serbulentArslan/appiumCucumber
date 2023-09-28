package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class ApiDemosHomeScreen {
    public ApiDemosHomeScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)),this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    public MobileElement homeScreenTitle;
    @AndroidFindBy(accessibility = "Preference")
    public MobileElement preferenceButton;



    public boolean isHomeScreenDisplayed(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return homeScreenTitle.isDisplayed();
    }


}
