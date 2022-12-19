package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.DogOrCatQuestion;
import tasks.DogOrCatTask;
import utils.Utilidad;

public class DogOrCatStepdefinition {


    @Managed
    WebDriver hisdriver;
    private EnvironmentVariables environmentVariables;

    @Before
    public void OpenWeb(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Luis Carlos");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisdriver));
    }
    @Given("Luis open page the lab cat or dog")
    public void luisOpenPageTheLabCatOrDog() {
        String Endpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(Utilidad.URL);
        String URL = Endpoint.toString();
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(URL));

    }

    @When("by clicking the generate image button, the animal that appears is chosen")
    public void byClickingTheGenerateImageButtonTheAnimalThatAppearsIsChosen() {
        OnStage.theActorInTheSpotlight().attemptsTo(DogOrCatTask.dogOrCatTask());

    }
    @Then("you get a successful response")
    public void youGetASuccessfulResponse() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(DogOrCatQuestion.dogOrCatQuestion(),
                Matchers.is(Matchers.equalTo(Utilidad.ASERCION))));

    }

}
