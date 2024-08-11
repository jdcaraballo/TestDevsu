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

    private final String descriptionSecondProduct;

    public FindSecondProduct(String descriptionSecondProduct) {
        this.descriptionSecondProduct = descriptionSecondProduct;
    }

    public static FindSecondProduct whitDescription(String descriptionSecondProduct) {
        return instrumented(FindSecondProduct.class, descriptionSecondProduct);
    }

    @Step("{0} busca el segundo producto ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        acceptProductAlert(actor);
        actor.attemptsTo(
                Click.on(PageProductPurchase.BUTTOM_HOME),
                Click.on(SELECT_TYPE_PRODUCT),
                WaitUntil.the(SELECTED_PRODUCT.of(descriptionSecondProduct), isVisible()),
                Click.on(SELECTED_PRODUCT.of(descriptionSecondProduct)),
                Click.on(PageProductPurchase.BUTTON_ADD_TO_CART)
        );
    }
    public void acceptProductAlert(Actor actor) {
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
    }
}