/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.poli.ingenieria.sistemas.controlador;

import co.edu.poli.ingenieria.sistemas.entidad.BotonesNumeros;
import co.edu.poli.ingenieria.sistemas.entidad.BotonesOperaciones;
import java.util.List;
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
    public String operacionEnMemoria;
    public List<String> operacionesList;
    public int numero;

    public calculadoraManaged() {
        display = "0";
    }
    
    public void oprimirBoton(String boton){
        /**Dado el caso que sea un numero*/
        impirmirDisplay(boton);
    }

    public void impirmirDisplay(String boton) {
       
        if (display.isEmpty() || display.equals("0")) {
            display = boton;
        } else { 
            display += boton;
        }

        operacionesList.add(boton);
    }
    
    public void determinarOperación(){
        int index = 0;
        int opera = 0;
        for(String boton : operacionesList){
            
            switch(boton){
                case BotonesOperaciones.SUMA :
                    /**Suma*/
                    opera = Integer.parseInt(operacionesList.get(index-1).toString()) 
                            + Integer.parseInt(operacionesList.get(index+1).toString()) ;
                    break;
                case BotonesOperaciones.RESTA:
                     opera = Integer.parseInt(operacionesList.get(index-1).toString()) 
                            / Integer.parseInt(operacionesList.get(index+1).toString()) ;
                    break;
                case BotonesOperaciones.MULTIPLICACION:
                    opera = Integer.parseInt(operacionesList.get(index-1).toString()) 
                            * Integer.parseInt(operacionesList.get(index+1).toString()) ;
                    break;

                case BotonesOperaciones.DIVISION:
                    opera = Integer.parseInt(operacionesList.get(index-1).toString()) 
                            / Integer.parseInt(operacionesList.get(index+1).toString()) ;
                    break;

                case BotonesOperaciones.RAIZ:
                     opera = Integer.parseInt(operacionesList.get(index-1).toString()) ;
                     break;

                case BotonesOperaciones.PORCENTAJE:
                    opera = Integer.parseInt(operacionesList.get(index-1).toString());
                    break;
                case BotonesOperaciones.PUNTO:
                    operacionesList.set(index-1, operacionesList.get(index-1).toString() + boton );
                    break;
            }
            index++;
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

    public List<String> getOperacionesList() {
        return operacionesList;
    }

    public void setOperacionesList(List<String> operacionesList) {
        this.operacionesList = operacionesList;
    }
    
    
}
