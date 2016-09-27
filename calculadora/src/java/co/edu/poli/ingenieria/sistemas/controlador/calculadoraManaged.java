/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.poli.ingenieria.sistemas.controlador;

import co.edu.poli.ingenieria.sistemas.entidad.BotonesNumeros;
import co.edu.poli.ingenieria.sistemas.entidad.BotonesOperaciones;
import co.edu.poli.ingenieria.sistemas.entidad.Memoria;
import co.edu.poli.ingenieria.sistemas.operaciones.EjecutarOperacion;
import co.edu.poli.ingenieria.sistemas.operaciones.impl.EjecutarOperacionImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author andres
 */
@ManagedBean
@ViewScoped
public class calculadoraManaged {

    /*Clases*/

    public EjecutarOperacion operacion = new EjecutarOperacionImpl();
    public Memoria memoria = new Memoria();

    /**
     * Variable
     */
    public String display;
    public boolean onOff;
    public String valorBoton; 

    public calculadoraManaged() {
        display = "0";
        onOff = false;
        valorBoton = "On";
    }


    public void impirmirDisplay(String boton) {

        if (display.isEmpty() || display.equals("0")) {
            display = boton;
        } else {
            display += boton;
        }

    }

    
    public void limpiarDisplay() {
        this.display = "0";
    }

    public void encender() {
        if (this.onOff == false) {
            this.onOff = true;
            this.valorBoton = "Off";
        } else {
            this.onOff = false;
            this.valorBoton = "On";
        }

    }
    
    
    public void asignarMemoria(){
        memoria.valor = display;
        String msj = "Número guardado en la memoria";
        enviarMensaje(msj);
    }
    
    public void llamarMemoria(){
        display += memoria.valor;
    }
    
    public void eliminarMemoria(){
        memoria.valor = "";
        String msj = "Número eliminado de la memoria";
        enviarMensaje(msj);
    }
    
    public void enviarMensaje(String mensaje){
        FacesMessage msg = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void resolverOperacion() throws Exception {
        display = operacion.resolverOperaciones(display);
        if (!display.isEmpty()) {
            System.out.println(display);

        }
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public String getValorBoton() {
        return valorBoton;
    }

    public void setValorBoton(String valorBoton) {
        this.valorBoton = valorBoton;
    }
    
    

}
