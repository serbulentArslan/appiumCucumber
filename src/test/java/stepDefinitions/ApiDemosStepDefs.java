package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import screens.Screens;
import utils.Driver;
import utils.ReusableMethods;

public class ApiDemosStepDefs extends ReusableMethods {

    Screens screens = new Screens();

    @Given("App yuklensin")
    public void app_yuklensin() {
        Driver.getAppiumDriver();
    }

    @Given("kullanici ana ekranda")
    public void kullanici_ana_ekranda() {
        Assert.assertTrue(isElementPresent(screens.mainScreen().mainScreenTitle));
    }

    @Given("kullanici API Demos butununa tikladi")
    public void kullanici_apı_demos_butununa_tikladi() {
        tapOn(screens.mainScreen().apiDemosButton);
    }

    @Then("kullanici API Demos ekraninda")
    public void kullanici_apı_demos_ekraninda() {
        Assert.assertTrue(isElementPresent(screens.apiDemosScreen().apiDemosTitle));
    }

    @Then("kullanici Preference butununa tikladi")
    public void kullanici_preference_butununa_tikladi() {
        tapOn(screens.apiDemosScreen().preference);
    }

    @Then("kullanici Preference ekraninda")
    public void kullanici_preference_ekraninda() {
        Assert.assertTrue(isElementPresent(screens.preferenceScreen().preferenceScreenTitle));
    }

    @Then("kullanici Preference dependencies tikladi")
    public void kullanici_preference_dependencies_tikladi() {
        tapOn(screens.preferenceScreen().preferenceDependencies);
    }

    @Then("kullanici WiFi check box secmis olacak")
    public void kullanici_wi_fi_check_box_secmis_olacak() {
        Assert.assertTrue(attributeChecked
                (screens.preferenceDependenciesScreen().checkBox, "checked"));
    }

    @Then("kullanici WiFi Settings tikladi")
    public void kullanici_wi_fi_settings_tikladi() {
        tapOn(screens.preferenceDependenciesScreen().wifiSettings);
    }

    @Then("WiFi setting popup geldi")
    public void wi_fi_setting_popup_geldi() {
        Assert.assertTrue(isElementPresent(screens.preferenceDependenciesScreen().cancelButton));
    }

    @Then("kullanici data yazdi")
    public void kullanici_data_yazdi() {
        enterText(screens.preferenceDependenciesScreen().textBox, "appiumTest");
    }

    @Then("kullanci ok butonuna tikladi")
    public void kullanci_ok_butonuna_tikladi() {
        tapOn(screens.preferenceDependenciesScreen().okButton);
    }

    @And("kullanici app kapatir")
    public void kullaniciAppKapatir() {
        Driver.quitAppiumDriver();
    }
}
