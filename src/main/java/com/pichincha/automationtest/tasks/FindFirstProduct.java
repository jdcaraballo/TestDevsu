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

    private final String descriptionFirstProduct;

    public FindFirstProduct(String descriptionFirstProduct) {
        this.descriptionFirstProduct = descriptionFirstProduct;
    }

    public static FindFirstProduct whitDescription(String descriptionFirstProduct) {
        return instrumented(FindFirstProduct.class, descriptionFirstProduct);
    }

    @Step("{0} busca el primer producto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SELECT_TYPE_PRODUCT),
                WaitUntil.the(SELECTED_PRODUCT.of(descriptionFirstProduct), isVisible()),
                Click.on(SELECTED_PRODUCT.of(descriptionFirstProduct)),
                Click.on(PageProductPurchase.BUTTON_ADD_TO_CART)
        );
    }
}