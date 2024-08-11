package com.pichincha.automationtest.tasks.apis.login_api;


import com.pichincha.automationtest.util.apis.SeleniumFunctions;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.junit.Assert;

import static com.pichincha.automationtest.util.apis.EndPointsDemoBlaze.INICIAR_SESION;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.PASSWORD_JHONATAN_FAILED;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.USERNAME_JHONATAN_FAILED;
import static com.pichincha.automationtest.util.apis.enumsRutasJson.EnumsRutasJson.MSG_PASS_WRONG;


public class LoginFailed implements Task {

    SeleniumFunctions functions = new SeleniumFunctions();

    public static Performable login() {
        return Tasks.instrumented(LoginFailed.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(INICIAR_SESION.toString()).
                        with(requestSpecification ->
                                requestSpecification.
                                        contentType(ContentType.JSON)
                                        .body("{" +
                                                '\"' + USERNAME_JHONATAN_FAILED.getLlave() + '\"' + ":" + '\"' + USERNAME_JHONATAN_FAILED.getValor() + '\"' + "," +
                                                '\"' + PASSWORD_JHONATAN_FAILED.getLlave() + '\"' + ":" + '\"' + PASSWORD_JHONATAN_FAILED.getValor() + '\"' +
                                                "}"
                                        )));

//        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());

        String messageDeRespuestaError = String.valueOf(SerenityRest.lastResponse().jsonPath().getString(MSG_PASS_WRONG.toString()));

        if (((messageDeRespuestaError)) == ("Wrong password.")) {
            Assert.assertEquals("Wrong password.", SerenityRest.lastResponse().jsonPath().getString(MSG_PASS_WRONG.toString()));
            System.out.println(messageDeRespuestaError);

        }  else if  (((messageDeRespuestaError)) == ("User does not exist.")) {
            Assert.assertEquals("User does not exist.", SerenityRest.lastResponse().jsonPath().getString(MSG_PASS_WRONG.toString()));
            System.out.println(messageDeRespuestaError);

        }else {
            Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());

        }

//        String showLabel = String.valueOf(SerenityRest.lastResponse().jsonPath().getString(MSG_PASS_WRONG.toString()));

        System.out.println("no se pudo iniciar sesion por: "+messageDeRespuestaError);

    }
 }
