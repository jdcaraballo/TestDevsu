package com.pichincha.automationtest.tasks.apis.sign_up_api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SignUp implements Task {

    private final String userType;

    public SignUp(String userType) {
        this.userType = userType;
    }

    public static SignUp signUp(String userType) {
        return instrumented(SignUp.class, userType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (userType) {
            case "Registred":
                signUpOk(actor);
                break;
            default:
                signUpFailed(actor);
                break;
        }
    }

    private void signUpOk(Actor actor) {
        actor.attemptsTo(
                SignUpOk.toRecord());
    }

    private void signUpFailed(Actor actor) {
        actor.attemptsTo(
                SignUpFailed.toRecord());
    }
}