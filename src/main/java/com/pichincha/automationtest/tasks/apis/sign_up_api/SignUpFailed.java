
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
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.PASSWORD_NEW_FAILED;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.USERNAME_NEW_FAILED;
import static com.pichincha.automationtest.util.apis.enumsRutasJson.EnumsRutasJson.MSG_PASS_WRONG;

public class SignUpFailed implements Task {

    SeleniumFunctions functions = new SeleniumFunctions();

    public static Performable toRecord(){
        return Tasks.instrumented(SignUpFailed.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(CREAR_CUENTA.toString()).
                        with(requestSpecification ->
                                requestSpecification.
                                        contentType(ContentType.JSON)
                                        .body("{" +
                                                '\"' + USERNAME_NEW_FAILED.getLlave() + '\"' + ":" + '\"' + USERNAME_NEW_FAILED.getValor() + '\"' + "," +
                                                '\"' +  PASSWORD_NEW_FAILED.getLlave() + '\"' + ":" + '\"' + PASSWORD_NEW_FAILED.getValor() + '\"' +
                                                "}"
                                        )));

        String messageDeRespuestaError = String.valueOf(SerenityRest.lastResponse().jsonPath().getString(MSG_PASS_WRONG.toString()));

        if (((messageDeRespuestaError)) == ("This user already exist.")) {
            Assert.assertEquals("This user already exist.", SerenityRest.lastResponse().jsonPath().getString(MSG_PASS_WRONG.toString()));
            System.out.println(messageDeRespuestaError);


        }else {
            Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());

        }
        System.out.println("no se pudo regiustrar la cuenta porque: "+messageDeRespuestaError);

    }
}