package com.pichincha.automationtest.util.apis.enumsEncrypt;

public enum EnumMsgEncrypt {
  PHRASSE_SECURITY("qualityinfosolutions"),
  ENCRYPT_ERROR("An error occurred while encrypting"),
  DECRYPT_ERROR("An error occurred while decrypting");

  private final String mensaje;

  EnumMsgEncrypt(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }
}
