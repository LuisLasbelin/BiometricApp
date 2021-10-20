package com.lbelmar.biometric;
// -------------------------------------------------------
// Autor: Luis Belloch
// Descripcion: Logica fake para acceder a la API
// Fecha: 15/10/2021
// -------------------------------------------------------

public class Logica {

    /**
     * obtenerTodasLasMedidas() -> [JSON]
     * Recibe las medidas del servidor REST
     */
    public static void obtenerTodasLasMedidas() { // Debe ser static para poder ser llamado desde el servicio
        // Hay que crearlo cada vez que vaya a usarse
        PeticionarioREST elPeticionario = new PeticionarioREST();
        elPeticionario.execute("GET", Constantes.URL + "medidas", null);
    }

    /**
     * obtenerUltimaMedida() -> [JSON]
     * Recibe la ultima medida de la base de datos
     */
    public static void obtenerUltimaMedida() {
        // Hay que crearlo cada vez que vaya a usarse
        PeticionarioREST elPeticionario = new PeticionarioREST();
        elPeticionario.execute("GET", Constantes.URL + "medida/ultima", null);
    }

    /**
     * medida:Medida -> guardarMedida()
     * Envia una medida al servidor REST
     *
     * @param medida objeto Medida
     */
    public static void guardarMedida(Medida medida) {
        // Hay que crearlo cada vez que vaya a usarse
        PeticionarioREST elPeticionario = new PeticionarioREST();
        // Post una medida desde los datos recibidos por el beacon
        elPeticionario.execute("POST", Constantes.URL + "medida", medida.toString());
    }
}
