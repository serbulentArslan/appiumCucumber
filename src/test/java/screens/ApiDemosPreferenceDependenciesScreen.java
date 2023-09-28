package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class ApiDemosPreferenceDependenciesScreen {
    public ApiDemosPreferenceDependenciesScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)),this);
    }

    @AndroidFindBy(id = "android:id/checkbox")
    public MobileElement wifiCheckBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WiFi settings']")
    public MobileElement wifiSettingsButton;
    @AndroidFindBy(id = "android:id/button2")
    public MobileElement cancelButton;
    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;
    @AndroidFindBy(id = "android:id/edit")
    public MobileElement textBox;


}
