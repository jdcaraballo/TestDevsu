package com.pichincha.automationtest.tasks;

import com.pichincha.automationtest.model.ModelProductPurchase;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pichincha.automationtest.ui.PageProductPurchase.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterCustomer implements Task {

    private final ModelProductPurchase data;

    public RegisterCustomer(ModelProductPurchase data) {
        this.data = data;
    }

    public static RegisterCustomer withInformation(ModelProductPurchase data) {
        return instrumented(RegisterCustomer.class, data);
    }

    @Step("{0} completa datos de compra")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_PLACE_ORDER),
                WaitUntil.the(INPIT_NAME, isVisible()),
                Enter.theValue(data.getName()).into(INPIT_NAME),
                Enter.theValue(data.getCountry()).into(INPUT_COUNTRY),
                Enter.theValue(data.getCity()).into(INPUT_CITY),
                Enter.theValue(data.getCarNumber()).into(INPUT_CREDIT_CARD),
                Enter.theValue(data.getExpirationMonth()).into(INPUT_MONTH),
                Enter.theValue(data.getExpirationYear()).into(INPUT_YEAR),
                Click.on(BUTTON_PURCHASE)
        );
    }
}