package com.pichincha.automationtest.tasks.apis.login_api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String userType;

    public Login(String userType) {
        this.userType = userType;
    }

    public static Login login(String userType) {
        return instrumented(Login.class, userType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (userType) {
            case "Registred User":
                loginOk(actor);
                break;
            default:
                loginFailed(actor);
                break;
        }
    }

    private void loginOk(Actor actor) {
        actor.attemptsTo(
                LoginOk.login());
    }

    private void loginFailed(Actor actor) {
        actor.attemptsTo(
                LoginFailed.login());
    }
}