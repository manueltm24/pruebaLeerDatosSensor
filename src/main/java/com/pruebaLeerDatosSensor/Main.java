package com.pruebaLeerDatosSensor;

import com.pruebaLeerDatosSensor.Clases.Muestra;
import com.pruebaLeerDatosSensor.Clases.Parametro;
import com.pruebaLeerDatosSensor.Services.BootStrapServices;
import com.pruebaLeerDatosSensor.Services.MuestraService;
import com.pruebaLeerDatosSensor.Services.ParametrosService;
import spark.Request;
import spark.Response;

import java.util.Set;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by MT on 6/24/2017.
 */
public class Main {
    public static void main(String[] args) {

        port(80);
       BootStrapServices.getInstancia().init(); // **Inicia la BD **
       initSpark(); // ** Inicia las funcionalidades Spark **

    }

    private static void initSpark() {
        //Linea para agregar la pantalla de debug. En productivo se debe quitar.
        enableDebugScreen();

        staticFiles.location("/publico");

        get("/",(request, response) ->{
            //ParametrosService.getInstancia().crear(new Parametro("PH"));
            //ParametrosService.getInstancia().crear(new Parametro("TEMPERATURA"));
            MuestraService.getInstancia().crear(new Muestra("PRUEBA",1));
            return "INSERT DE PARAMETROSS";
        });

        /**
         * Obteniendo los parametros...
         * http://localhost:4567/parametros?param1=valor1&param2=valor2&paramN=valorN
         */
        get("/parametros", (request, response) -> {
           procesarParametros(request, response); //encapsular las petición y las respuetas.

            return "Nuevos paramatros procesados:";
        });

        post("/parametros", (request, response) -> {
            return procesarParametros(request, response);
        });

    }


    private static Object procesarParametros(Request request, Response response){
        System.out.println("Recibiendo mensaje por el metodo: "+request.requestMethod());
        Set<String> parametros = request.queryParams();
        String salida="";
        float valor=0;
        for(String param : parametros){
            salida+=String.format("Parametro[%s] = %s <br/>", param, request.queryParams(param));
            //System.out.println(request.queryParams(param));
            valor=Float.parseFloat(request.queryParams(param));
            System.out.println(valor);
            System.out.println(param);
            if(param.equals("param1"))
                MuestraService.getInstancia().crear(new Muestra("PH",valor));
            if(param.equals("param2"))
                MuestraService.getInstancia().crear(new Muestra("TEMPERATURA",valor));
        }
        return salida;
    }
}
