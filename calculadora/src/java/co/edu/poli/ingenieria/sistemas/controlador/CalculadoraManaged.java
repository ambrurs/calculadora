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
public class CalculadoraManaged {
    /*Clases*/
    public BotonesOperaciones botonesoperaciones;
    public BotonesNumeros botonesNumeros;
    
    
    /**Variable*/
    public String display;
    public  int numero;
    
    public CalculadoraManaged() {     
        display = "0";
    }
 
    public void impirmirDisplay(String boton){
    
        if(display.isEmpty()){
            display = boton;
        }else{
            display += display+boton;
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

    public BotonesOperaciones getBotonesoperaciones() {
        return botonesoperaciones;
    }

    public void setBotonesoperaciones(BotonesOperaciones botonesoperaciones) {
        this.botonesoperaciones = botonesoperaciones;
    }

    public BotonesNumeros getBotonesNumeros() {
        return botonesNumeros;
    }

    public void setBotonesNumeros(BotonesNumeros botonesNumeros) {
        this.botonesNumeros = botonesNumeros;
    }
    
    
}
