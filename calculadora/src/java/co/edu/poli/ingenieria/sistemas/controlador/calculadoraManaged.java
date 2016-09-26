/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.poli.ingenieria.sistemas.controlador;

import co.edu.poli.ingenieria.sistemas.entidad.BotonesNumeros;
import co.edu.poli.ingenieria.sistemas.entidad.BotonesOperaciones;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andres
 */
@ManagedBean
@ViewScoped
public class calculadoraManaged {

     /*Clases*/

    public BotonesOperaciones botonesOperaciones;
    public BotonesNumeros botonesNumeros;

    /**
     * Variable
     */
    public String display;
    public int numero;

    public calculadoraManaged() {
        display = "0";
    }

    public void impirmirDisplay(String boton) {
       
        if (display.isEmpty()) {
            display = boton;
        } else { 
            display += boton;
        }

    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = botonesNumeros.valor;
    }

    public BotonesOperaciones getBotonesOperaciones() {
        return botonesOperaciones;
    }

    public void setBotonesOperaciones(BotonesOperaciones botonesOperaciones) {
        this.botonesOperaciones = botonesOperaciones;
    }

    public BotonesNumeros getBotonesNumeros() {
        return botonesNumeros;
    }

    public void setBotonesNumeros(BotonesNumeros botonesNumeros) {
        this.botonesNumeros = botonesNumeros;
    }
}
