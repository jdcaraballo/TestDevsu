package com.pichincha.automationtest.util.apis;

public enum EnumsHeadersDemoBlaze {


  USERNAME_JHONATAN_OK("username", "FqYRu4JecaVrhLfk2E61m4pTmFkkjx3s"),
  PASSWORD_JHONATAN_OK("password", "KW3BL19V9nc="),
  USERNAME_NEW_OK("username", "david123456@gmail.com"),
  PASSWORD_NEW_OK("password", "123456"),
  USERNAME_NEW_FAILED("username", "david12@gmail.com"),
  PASSWORD_NEW_FAILED("password", "123456"),
  USERNAME_JHONATAN_FAILED("username", "david011010101@gmail.com"),
  PASSWORD_JHONATAN_FAILED("password", "K124356"),
  API_KEY("Content-Type", "application/json");


  private final String llave;
  private final String valor;

  EnumsHeadersDemoBlaze(String llave, String valor) {
    this.llave = llave;
    this.valor = valor;
  }

  public String getLlave() {
    return llave;
  }

  public String getValor() {
    return valor;
  }

}
