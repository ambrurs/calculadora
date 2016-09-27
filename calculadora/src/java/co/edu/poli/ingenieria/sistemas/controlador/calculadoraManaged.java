/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.poli.ingenieria.sistemas.controlador;

import co.edu.poli.ingenieria.sistemas.entidad.BotonesNumeros;
import co.edu.poli.ingenieria.sistemas.entidad.BotonesOperaciones;
import co.edu.poli.ingenieria.sistemas.operaciones.EjecutarOperacion;
import co.edu.poli.ingenieria.sistemas.operaciones.impl.EjecutarOperacionImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
    public EjecutarOperacion operacion = new EjecutarOperacionImpl();

    /**
     * Variable
     */
    public String display;
    public String operacionEnMemoria;
    public ArrayList<String> operacionesList = new ArrayList();
    public int numero;
    public boolean onOff;

    public calculadoraManaged() {
        display = "0";
        onOff = false;
    }

    public void oprimirBoton(String boton) {
        /**
         * Dado el caso que sea un numero
         */
        impirmirDisplay(boton);
        operacionesList.add(boton);
        determinarOperación();
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
        } else {
            this.onOff = false;
        }

    }

    public void determinarOperación() {
        Integer numero = 0;
        ListIterator<String> it = operacionesList.listIterator();
        while (it.hasNext()) {

            switch (it.toString()) {
                case BotonesOperaciones.SUMA:
                    /**
                     * Suma
                     */
                    if (it.next() != null) {
                        numero = Integer.parseInt(it.previous())
                                + Integer.parseInt(it.next());
                    }
                    break;
                case BotonesOperaciones.RESTA:
                    if (it.next() != null) {
                        numero = Integer.parseInt(it.previous())
                                - Integer.parseInt(it.next());
                    }
                    break;
                case BotonesOperaciones.MULTIPLICACION:
                    if (it.next() != null) {
                        numero = Integer.parseInt(it.previous())
                                * Integer.parseInt(it.next());
                    }
                    break;

                case BotonesOperaciones.DIVISION:
                    if (it.next() != null) {
                        numero = Integer.parseInt(it.previous())
                                / Integer.parseInt(it.next());
                    }
                    break;

                case BotonesOperaciones.RAIZ:
                    if (it.next() != null) {
                        numero = Integer.parseInt(it.next());
                    }
                    break;

                case BotonesOperaciones.PORCENTAJE:
                    if (it.previous() != null) {
                        numero = Integer.parseInt(it.previous());
                    }
                    break;
//                case BotonesOperaciones.PUNTO:
//                    operacionesList.set(index-1, operacionesList.get(index-1).toString()  );
//                    break;
            }
        }
        operacionEnMemoria = numero.toString();
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

    public String getOperacionEnMemoria() {
        return operacionEnMemoria;
    }

    public void setOperacionEnMemoria(String operacionEnMemoria) {
        this.operacionEnMemoria = operacionEnMemoria;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

}
