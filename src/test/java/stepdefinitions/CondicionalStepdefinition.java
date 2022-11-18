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
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.CondicionalQuestion;
import tasks.CondicionalTask;
import utils.Utilidad;

import static utils.Utilidad.DIRECCION;

public class CondicionalStepdefinition {

    @Managed
    WebDriver hisdriver;
    private EnvironmentVariables environmentVariable;

    @Before
    public void Open() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Luis");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisdriver));
    }

    @Given("^Luis open page the lab$")
    public void luisOpenPageTheLab() {
        String wbserviceEndpoint = EnvironmentSpecificConfiguration.from(environmentVariable).
                getProperty(DIRECCION);
        String URL = wbserviceEndpoint.toString();
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(URL));

    }

    @When("^click on the generate color button and the text is displayed$")
    public void clickOnTheGenerateColorButtonAndTheTextIsDisplayed() {
        OnStage.theActorInTheSpotlight().attemptsTo(CondicionalTask.condicionalTask());
    }

    @Then("^it will be displayed if the condition is correct or incorrect$")
    public void itWillBeDisplayedIfTheConditionIsCorrectOrIncorrect() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CondicionalQuestion.condicionalQuestion(),
                Matchers.is(Matchers.equalTo(Utilidad.ASERCION))));

    }
}