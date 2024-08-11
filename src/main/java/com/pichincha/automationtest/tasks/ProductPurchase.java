package com.pichincha.automationtest.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.pichincha.automationtest.ui.PageProductPurchase.MENU_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductPurchase implements Task {
    public ProductPurchase() {
    }

    public static ProductPurchase toCart( ) {
        return instrumented(ProductPurchase.class);
    }

    @Step("{0} añade el producto #description al carrito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        acceptProduct(actor);
        actor.attemptsTo(
                Click.on(MENU_CART)
        );
    }

    public void acceptProduct(Actor actor) {
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
    }
}