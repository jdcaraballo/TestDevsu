package com.pichincha.automationtest.glue.demo;

import com.pichincha.automationtest.questions.ValidacionDeRespuestaOk;
import com.pichincha.automationtest.tasks.apis.login_api.Login;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import lombok.extern.slf4j.Slf4j;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
@Slf4j
public class LoginApiStep {

    @Cuando("Jhonatan makes login with user (.*)$")
    public void elIniciaSesion(String userType) {
        theActorInTheSpotlight().attemptsTo(
                Login.login(userType));
    }

    @Entonces("^se vera codigo statusCode (.*)$")
    public void validateTheSuccessfulMarkingOfTheStop(int statusCode) {
        theActorInTheSpotlight().should(seeThat(
                ValidacionDeRespuestaOk.es(statusCode)));
    }
}

