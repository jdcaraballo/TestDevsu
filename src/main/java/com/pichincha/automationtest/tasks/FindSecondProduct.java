package com.pichincha.automationtest.tasks;

import com.pichincha.automationtest.ui.PageProductPurchase;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.pichincha.automationtest.ui.PageProductPurchase.SELECTED_PRODUCT;
import static com.pichincha.automationtest.ui.PageProductPurchase.SELECT_TYPE_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FindSecondProduct implements Task {

    private final String descriptionProductDos;

    public FindSecondProduct(String descriptionProductDos) {
        this.descriptionProductDos = descriptionProductDos;
    }

    public static FindSecondProduct whitDescription(String descriptionProductDos) {
        return instrumented(FindSecondProduct.class, descriptionProductDos);
    }

    @Step("{0} busca el segundo producto ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        acceptProductAlert(actor);
        actor.attemptsTo(
                Click.on(PageProductPurchase.BUTTOM_HOME),
                Click.on(SELECT_TYPE_PRODUCT),
                WaitUntil.the(SELECTED_PRODUCT.of(descriptionProductDos), isVisible()),
                Click.on(SELECTED_PRODUCT.of(descriptionProductDos)),
                Click.on(PageProductPurchase.BUTTON_ADD_TO_CART)
        );
    }
    public void acceptProductAlert(Actor actor) {
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
    }
}