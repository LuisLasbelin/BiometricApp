package com.lbelmar.biometric;

import android.util.Log;

public class Logica {

    // API REST
    private static PeticionarioREST elPeticionario = new PeticionarioREST();

    /**
     * Recibe las medidas del servidor REST
     */
    public static void getTodasLasMedidas() {
        elPeticionario.hacerPeticionREST("GET", Constantes.URL + "medidas", null,
                new PeticionarioREST.RespuestaREST () {
                    @Override
                    public void callback(int codigo, String cuerpo) {
                        Log.d("API-REST", "codigo respuesta= " + codigo + " <-> \n" + cuerpo);
                    }
                }
        );
    }

    /**
     * Envia una medida al servidor REST
     * `medida/` + valor + "/" + latitud + "/" + longitud + "/" + sensor
     * @param medida objeto Medida
     */
    public static void postMedida(Medida medida) {
        // Post una medida desde los datos recibidos por el beacon
        elPeticionario.hacerPeticionREST("POST", Constantes.URL + "medida/" +
                        medida.medicion_valor + "/" + medida.medicion_valor + "/" + medida.latitud + "/" + medida.longitud + "/" + medida.sensor_id,
                null,
                new PeticionarioREST.RespuestaREST () {
                    @Override
                    public void callback(int codigo, String cuerpo) {
                        Log.d("API-REST", "codigo respuesta= " + codigo + " <-> \n" + cuerpo);
                    }
                }
        );
    }
}
