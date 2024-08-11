package com.pichincha.automationtest.util.apis.enumsRutasJson;

public enum EnumsRutasJson {
    MSG_PASS_WRONG("errorMessage"),
    MSG_SUCCESS_LOGIN("Auth_token: ");
    private final String endPoints;

    EnumsRutasJson(String endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public String toString() { return endPoints; }
}
