package com.pichincha.automationtest.tasks.apis.login_api;

import com.pichincha.automationtest.util.apis.SeleniumFunctions;
import com.pichincha.automationtest.util.apis.encrypt.Encrypt;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.junit.Assert;

import static com.pichincha.automationtest.util.apis.EndPointsDemoBlaze.INICIAR_SESION;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.PASSWORD_JHONATAN_OK;
import static com.pichincha.automationtest.util.apis.EnumsHeadersDemoBlaze.USERNAME_JHONATAN_OK;


public class LoginOk implements Task {

    SeleniumFunctions functions = new SeleniumFunctions();

    public static Performable login(){
        return Tasks.instrumented(LoginOk.class);
    }
    String usuario= Encrypt.decrypt(USERNAME_JHONATAN_OK.getValor());
    String clave=Encrypt.decrypt(PASSWORD_JHONATAN_OK.getValor());



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(INICIAR_SESION.toString()).
                        with(requestSpecification ->
                                requestSpecification.
                                        contentType(ContentType.JSON)
                                        .body("{" +
                                                '\"' + USERNAME_JHONATAN_OK.getLlave() + '\"' + ":" + '\"' + usuario + '\"' +"," +
                                                '\"' +  PASSWORD_JHONATAN_OK.getLlave() + '\"' + ":" + '\"' + clave + '\"' +
                                                "}"
                                        )));

        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());

//        String idToken = String.valueOf(SerenityRest.lastResponse().jsonPath().getString(MSG_SUCCESS_LOGIN.toString()));

//        System.out.println("Auth_token: "+idToken);



    }

}
