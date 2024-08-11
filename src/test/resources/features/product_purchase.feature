@RetoDevsu
Feature:  Reto Web Devsu, se quiere comprar dos productos

  @id:1 @ProductPurchase
  Scenario Outline: Compra de productos tecnologicos.
  Para realizar una compra exitosa de un producto  como cliente sin realizar login en la aplicación  necesito ser capaz de realizar y verificar la compra
    Given que el Jhonatan David ingresa a la pagina de demoblaze para seleccionar el "<productoUno>" y "<productoDos>"
    When el decide hacer la compra ingresa sus datos personales
      | name   | country   | city   | card   | month   | year   |
      | <name> | <country> | <city> | <card> | <month> | <year> |
    Then el realiza la compra del producto exitosamente
    Examples:
      | @externaldata@demo/WebDataCompraTelefono.xlsx..compra |

  

