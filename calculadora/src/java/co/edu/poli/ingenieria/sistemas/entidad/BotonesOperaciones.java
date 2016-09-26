/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.poli.ingenieria.sistemas.entidad;

/**
 *
 * @author andres
 */

public enum BotonesOperaciones {
    /**Operaciones actuales*/
    SUMA("+",1),
    RESTA("-",2),
    MULTIPLICACION("*",3),
    DIVISION("/",4),
    RAIZ("&#8730;",5),
    PORCENTAJE("%",6);
    
    
    public String nombre;
    public int id;
    /**Se sobreescribe el constructor */
    private BotonesOperaciones(String nombre , int id){
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}