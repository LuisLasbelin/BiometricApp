package com.lbelmar.biometric;

public class Logica {


    /**
     * Recibe las medidas del servidor REST
     */
    public static void obtenerTodasLasMedidas() {
        // Hay que crearlo cada vez, si no, se rompe
        PeticionarioREST elPeticionario = new PeticionarioREST();
        elPeticionario.execute("GET", Constantes.URL + "medidas", null);
    }

    /**
     * Envia una medida al servidor REST
     *
     * @param medida objeto Medida
     */
    public static void guardarMedida(Medida medida) {
        PeticionarioREST elPeticionario = new PeticionarioREST();
        // Post una medida desde los datos recibidos por el beacon
        elPeticionario.execute("POST", Constantes.URL + "medida", medida.toString());
    }
}
