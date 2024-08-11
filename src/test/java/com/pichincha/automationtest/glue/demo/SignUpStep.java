package com.pichincha.automationtest.glue.demo;

import com.pichincha.automationtest.questions.ValidacionDeRespuestaOk;
import com.pichincha.automationtest.tasks.apis.sign_up_api.SignUp;
import com.pichincha.automationtest.util.apis.BeforeHook;
import com.pichincha.automationtest.util.apis.SeleniumFunctions;
import cucumber.api.java.en.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
@Slf4j
public class SignUpStep {

    SeleniumFunctions functions = new SeleniumFunctions();

    @Given("that Jhonatan uses the service {string}")
    @When("Jhonatan makes login on page with user {string}")
    public void userMakesLoginonpagewithNoPreviousregistred(String urlBase) throws IOException {
        functions.retrieveTestData(urlBase);
        BeforeHook.prepareStage(functions.getScenarioData(urlBase));
    }

    @When("Jhonatan se autentica en la pagina con correo (.*)$")
    public void elCreaCuentaOK(String userType) {
        theActorInTheSpotlight().attemptsTo(
                SignUp.signUp(userType));
    }

    @Then("^he will see status code (.*)$")
    public void validateCreation(int statusCode) {
        theActorInTheSpotlight().should(seeThat(
                ValidacionDeRespuestaOk.es(statusCode)));
    }
}

