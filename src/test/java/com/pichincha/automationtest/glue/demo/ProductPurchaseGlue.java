package com.pichincha.automationtest.glue.demo;

import com.pichincha.automationtest.actions.HomePage;
import com.pichincha.automationtest.tasks.FindFirstProduct;
import com.pichincha.automationtest.tasks.FindSecondProduct;
import com.pichincha.automationtest.tasks.ProductPurchase;
import com.pichincha.automationtest.tasks.RegisterCustomer;
import com.pichincha.automationtest.model.ModelProductPurchase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

import static com.pichincha.automationtest.ui.PageProductPurchase.LABEL_SUCCESSFULL_PURCHASE;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@Slf4j
public class ProductPurchaseGlue {


    @Given("que el {actor} ingresa a la pagina de demoblaze para seleccionar el {string} y {string}")
    public void queElActorIngresaALaPaginaDeDemoblazeParaSeleccionarEl(Actor actor, String descriptionProductUno, String descriptionProductDos) {
        givenThat(actor).attemptsTo(
                HomePage.inPage(),
                FindFirstProduct.whitDescription(descriptionProductUno),
                FindSecondProduct.whitDescription(descriptionProductDos),
                ProductPurchase.toCart()
        );
    }

    @When("el decide hacer la compra ingresa sus datos personales")
    public void ySeIdentificaConLosDatosDeCompraY(List<List<String>> data) {
        when(theActorInTheSpotlight()).wasAbleTo(
                RegisterCustomer.withInformation(new ModelProductPurchase(data))
        );
    }

    @Then("el realiza la compra del producto exitosamente")
    public void completaLaCompraExitosamenteDelProducto() {
        then(theActorInTheSpotlight()).should(
                seeThat(the(LABEL_SUCCESSFULL_PURCHASE), isPresent())
        );
    }
}