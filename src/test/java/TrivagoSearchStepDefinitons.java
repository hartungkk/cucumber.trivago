import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TrivagoSearchStepDefinitons {


    @When("click to search button")
    public void clickSearchIcon() {
        $(byClassName("search-icon")).waitUntil(Condition.visible, 10000).click();
    }

    @When("wait visible search layout and search input")
    public void waitVisibleSearchContainer() {
        $(byId("search")).waitUntil(Condition.visible, 10000);
        $(byXpath("//div[contains(@class,'search-input-wrapper')]//input")).waitUntil(Condition.visible, 10000);
        $$(byXpath("//div[@id='search']//div[@class='filter-tag']")).first().waitUntil(Condition.visible, 10000);
    }

    @When("send to search input field (.*) and press Enter")
    public void sendKeywordsIntoSearchInput(String value) {
        $(byXpath("//div[contains(@class,'search-input-wrapper')]//input")).setValue(value).pressEnter();
    }

    @Then("wait number (.*) articles in search results")
    public void waitVisibleSearchResults(String number) {
        $(byXpath("//h3[@class='section-title']")).waitUntil(Condition.visible, 10000).shouldHave(Condition.matchesText(number + " Search Results"));
        $$(byXpath("//div[@class='search-results']//section[@class='posts-section']//div[contains(@class,'article-card')]")).shouldHaveSize(Integer.parseInt(number));
    }
}
