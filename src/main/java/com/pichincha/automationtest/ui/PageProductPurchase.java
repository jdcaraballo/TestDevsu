package com.pichincha.automationtest.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageProductPurchase extends PageObject {

    public static final Target MENU_CART = Target.the("'Menú Carrito de compras'").locatedBy("//a[@id='cartur']");
    public static final Target SELECT_TYPE_PRODUCT = Target.the("'Botón de tipo de producto'").located(By.xpath("//a[contains(text(),'Phones')]"));
    public static final Target SELECTED_PRODUCT = Target.the("'Link de producto encontrado'").locatedBy("//a[contains(text(),'{0}')]");
    public static final Target BUTTON_PLACE_ORDER = Target.the("'Botón de Compra'").locatedBy("//button[text()='Place Order']");
    public static final Target BUTTON_PURCHASE = Target.the("'Botón de realizar Compra'").locatedBy("//button[text()='Purchase']");
    public static final Target LABEL_SUCCESSFULL_PURCHASE = Target.the("'Compra exitosa'").locatedBy("//*[.='Thank you for your purchase!']");
    public static final Target BUTTON_ADD_TO_CART = Target.the("'botón para añadir al carrito el producto'").locatedBy("//a[@class='btn btn-success btn-lg']");
    public static final Target BUTTOM_HOME = Target.the("'botón para ir a HomePage'").locatedBy("//*[@class='nav-item active']//*[contains(text(),'Home')]");
    public static final Target INPIT_NAME = Target.the("'Nombre de Cliente'").located(By.id("name"));
    public static final Target INPUT_COUNTRY = Target.the("'Pais de la tarjeta'").located(By.id("country"));
    public static final Target INPUT_CITY = Target.the("'Ciudad de la tarjeta'").located(By.id("city"));
    public static final Target INPUT_CREDIT_CARD = Target.the("'Numero de Tarjeta'").located(By.id("card"));
    public static final Target INPUT_MONTH = Target.the("'Mes de vencimiento'").located(By.id("month"));
    public static final Target INPUT_YEAR = Target.the("'Año de vencimiento'").located(By.id("year"));
}