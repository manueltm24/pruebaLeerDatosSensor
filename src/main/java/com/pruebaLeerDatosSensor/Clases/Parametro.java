package com.pruebaLeerDatosSensor.Clases;

import javax.persistence.*;

/**
 * Created by MT on 6/24/2017.
 */
@Entity
public class Parametro {
    @Id
    @GeneratedValue
    private long id;
    private String nombreParametro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public Parametro(){

    }

    public Parametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }
}
