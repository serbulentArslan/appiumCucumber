package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import screens.ApiDemosHomeScreen;
import screens.ApiDemosPreferenceDependenciesScreen;
import screens.ApiDemosPreferenceScreen;
import utils.Driver;

public class apiDemosStepDefs {
    ApiDemosHomeScreen homeScreen = new ApiDemosHomeScreen();
    ApiDemosPreferenceScreen preferenceScreen = new ApiDemosPreferenceScreen();
    ApiDemosPreferenceDependenciesScreen preferenceDependenciesScreen = new ApiDemosPreferenceDependenciesScreen();

    @Given("app yuklendi")
    public void app_yuklendi() {
        Driver.getAppiumDriver();
    }

    @Given("ana sayfada oldugunu dogrula")
    public void ana_sayfada_oldugunu_dogrula() {
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
    }

    @Then("Prefence butonuna tikla ve o sayfada oldugunu dogrula")
    public void prefence_butonuna_tikla_ve_o_sayfada_oldugunu_dogrula() {
        homeScreen.preferenceButton.click();
    }

    @Then("Prefence dependencies butonuna tikla")
    public void prefence_dependencies_butonuna_tikla() {
        preferenceScreen.preferenceDependenciesButton.click();
    }

    @Then("Checkbox secili olacak")
    public void checkbox_secili_olacak() {
        if (preferenceDependenciesScreen.wifiCheckBox.getAttribute("checked").equals("false")){
            preferenceDependenciesScreen.wifiCheckBox.click();
        }
        Assert.assertTrue(preferenceDependenciesScreen.wifiCheckBox.isSelected());
    }

    @Then("WiFi setting butonuna tikla")
    public void wi_fi_setting_butonuna_tikla() {
        preferenceDependenciesScreen.wifiSettingsButton.click();
    }

    @Then("Wifi settings popup geldigini dogrula")
    public void wifi_settings_popup_geldigini_dogrula() {
        Assert.assertTrue(preferenceDependenciesScreen.cancelButton.isDisplayed());
    }

    @Then("text alanina data gonder")
    public void text_alanina_data_gonder() {
        preferenceDependenciesScreen.textBox.sendKeys("appiumTest");
    }

    @Then("ok butonuna tikla")
    public void ok_butonuna_tikla() {
        preferenceDependenciesScreen.okButton.click();
    }
}
