package com.pruebaLeerDatosSensor.Services;

import com.pruebaLeerDatosSensor.Clases.Muestra;
import com.pruebaLeerDatosSensor.GestionDb;

/**
 * Created by MT on 6/24/2017.
 */
public class MuestraService extends GestionDb<Muestra> {
    private static MuestraService instancia;

    private MuestraService() {
        super(Muestra.class);
    }

    public static MuestraService getInstancia(){
        if(instancia==null){
            instancia = new MuestraService();
        }
        return instancia;
    }
}
