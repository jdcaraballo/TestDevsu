package com.pichincha.automationtest.util.apis;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GestionarDatos {

    private final Properties propiedades = new Properties();
    private final InputStream en = GestionarDatos.class.getResourceAsStream("/endpoint.properties");
    private static final Map<String, String> datosDeEscenario = new HashMap<>();

    public String leerPropiedades(String propiedadExplicita) throws IOException {
        propiedades.load(en);
        return propiedades.getProperty(propiedadExplicita);
    }

    public void datosPrueba(String parametros) throws IOException {
        guardarDatos(parametros, leerPropiedades(parametros));
    }

    public void guardarDatos(String llave, String texto) {
        if (!datosDeEscenario.containsKey(llave)) {
            datosDeEscenario.put(llave, texto);
        } else {
            datosDeEscenario.replace(llave, texto);
        }
    }
    public String obtenerDatos(String llave) {
        boolean exist = datosDeEscenario.containsKey(llave);
        String texto = "";
        if (exist) {
            texto = datosDeEscenario.get(llave);
        }else {
        }
        return texto;
    }
}
