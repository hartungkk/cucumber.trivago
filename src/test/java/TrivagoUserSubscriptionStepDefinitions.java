import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrivagoUserSubscriptionStepDefinitions {
    String email;

    @Given("an open browser with room5.trivago.com")
    public void openTrivagoPage() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "target/surefire-reports";
        open("http://room5.trivago.com/");
    }

    @When("scroll to footer and send email address (.*) is footer input field")
    public void fillToEmailInput(String email) {
        this.email = email;
        $(byXpath("//div[contains(@class,'newsletter-title')]")).waitUntil(Condition.visible, 10000);
        $(byXpath("//div[contains(@class,'newsletter-inputs')]//input")).scrollTo().setValue(email);
    }

    @When("click \"Inspire Me\" button")
    public void clickInspireMeButton() {
        $(byXpath("//div[contains(@class,'newsletter-inputs')]//button")).click();
    }

    @Then("show successful message in footer")
    public void waitSuccessfulMessage() {
        $(byXpath("//p[contains(@class,'submitted')]")).waitUntil(Condition.visible, 10000).waitUntil(Condition.text("You are now checked-in!"), 10000);
    }
}
