package com.pichincha.automationtest.tasks.apis.sign_up_api;

import com.pichincha.automationtest.util.apis.SeleniumFunctions;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.junit.Assert;

import static com.pichincha.automationtest.util.apis.EndPointsDemoBlaze.CREAR_CUENTA;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.PASSWORD_NEW_OK;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.USERNAME_NEW_OK;

public class SignUpOk implements Task {

    SeleniumFunctions functions = new SeleniumFunctions();

    public static Performable toRecord(){
        return Tasks.instrumented(SignUpOk.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(CREAR_CUENTA.toString()).
                        with(requestSpecification ->
                                requestSpecification.
                                        contentType(ContentType.JSON)
                                        .body("{" +
                                                '\"' + USERNAME_NEW_OK.getLlave() + '\"' + ":" + '\"' + USERNAME_NEW_OK.getValor() + '\"' + "," +
                                                '\"' +  PASSWORD_NEW_OK.getLlave() + '\"' + ":" + '\"' + PASSWORD_NEW_OK.getValor() + '\"' +
                                                "}"
                                        )));

        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());

    }

}
