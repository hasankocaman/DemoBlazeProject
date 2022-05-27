package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ClientAddsSonyVaioI5Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtilities;

import java.time.Duration;

public class ClientAddsSonyStepDefs {
    ClientAddsSonyVaioI5Page client=new ClientAddsSonyVaioI5Page();

    @When("user navigates to the home page")
    public void user_navigates_to_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("demo_blaze_url"));
    }
    @When("user clicks on Laptops button")
    public void user_clicks_on_laptops_button() {
        client.laptopsButton.click();

    }
    @When("user clicks on Sony vaio i5")
    public void user_clicks_on_sony_vaio_i5() throws InterruptedException {
        Thread.sleep(2000);
        JSUtilities.scrollIntoViewJS(client.sonyVaio);
        client.sonyVaio.click();
    }
    @Then("user clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() throws InterruptedException {
        Driver.waitForVisibility(client.addToCartButton,15);
        client.addToCartButton.click();
        Thread.sleep(1000);

    }
    @Then("user need to accept pop up confirmation")
    public void user_need_to_accept_pop_up_confirmation() {
        try {
            Driver.getDriver().switchTo().alert().dismiss();
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = Driver.getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }








}
