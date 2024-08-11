package com.pichincha.automationtest.questions;


import com.pichincha.automationtest.util.apis.SeleniumFunctions;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.junit.Assert;



public class ValidacionDeRespuesta implements Question<Boolean> {

    SeleniumFunctions functions = new SeleniumFunctions();

    private final int statusCode;

    public ValidacionDeRespuesta(int statusCode ) {
        this.statusCode = statusCode;

    }

    public static ValidacionDeRespuesta es(int statusCode) {
        return new ValidacionDeRespuesta(statusCode);
    }

        @Override
    public Boolean answeredBy(Actor actor) {

            Assert.assertEquals(statusCode, SerenityRest.lastResponse().statusCode());
            return true;
        }

}
