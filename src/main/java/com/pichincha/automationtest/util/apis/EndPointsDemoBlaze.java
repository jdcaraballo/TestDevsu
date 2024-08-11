package com.pichincha.automationtest.util.apis;

public enum EndPointsDemoBlaze {
    CREAR_CUENTA("/signup"),
    INICIAR_SESION("/login");


    private final String uri;

    EndPointsDemoBlaze(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() { return uri; }

}



