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

    @Given("that {actor} goes to demoblaze page to select the {string} and {string}")
    public void theActorGoesToDemoblazePageToSelectTwoProducts(Actor actor, String descriptionFirstProduct, String descriptionSecondProduct) {
        givenThat(actor).attemptsTo(
                HomePage.inPage(),
                FindFirstProduct.whitDescription(descriptionFirstProduct),
                FindSecondProduct.whitDescription(descriptionSecondProduct),
                ProductPurchase.toCart()
        );
    }

    @When("he wants to make a purchase enter his personal data")
    public void heWantsToMakePurchaseEnterHisPersonalData(List<List<String>> data) {
        when(theActorInTheSpotlight()).wasAbleTo(
                RegisterCustomer.withInformation(new ModelProductPurchase(data))
        );
    }

    @Then("he can see Successesful purchase message")
    public void heCanSeeSuccessesfulPurchaseMessage() {
        then(theActorInTheSpotlight()).should(
                seeThat(the(LABEL_SUCCESSFULL_PURCHASE), isPresent())
        );
    }
}