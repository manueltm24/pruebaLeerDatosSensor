package com.pruebaLeerDatosSensor.Clases;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MT on 6/24/2017.
 */
@Entity
public class Muestra {

    @Id
    @GeneratedValue
    private long id;
    private String parametro;
    private float valor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor1) {
        this.valor = valor;
    }


    public Muestra(){

    }

    public Muestra(String parametro, float valor) {
        this.parametro = parametro;
        this.valor = valor;
    }



}
