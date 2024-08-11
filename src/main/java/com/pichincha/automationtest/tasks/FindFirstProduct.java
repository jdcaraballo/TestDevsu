package com.pichincha.automationtest.tasks;

import com.pichincha.automationtest.ui.PageProductPurchase;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.pichincha.automationtest.ui.PageProductPurchase.SELECTED_PRODUCT;
import static com.pichincha.automationtest.ui.PageProductPurchase.SELECT_TYPE_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FindFirstProduct implements Task {

    private final String descriptionProductUno;

    public FindFirstProduct(String descriptionProductUno) {
        this.descriptionProductUno = descriptionProductUno;
    }

    public static FindFirstProduct whitDescription(String descriptionProductUno) {
        return instrumented(FindFirstProduct.class, descriptionProductUno);
    }

    @Step("{0} busca el primer producto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SELECT_TYPE_PRODUCT),
                WaitUntil.the(SELECTED_PRODUCT.of(descriptionProductUno), isVisible()),
                Click.on(SELECTED_PRODUCT.of(descriptionProductUno)),
                Click.on(PageProductPurchase.BUTTON_ADD_TO_CART)
        );
    }
}