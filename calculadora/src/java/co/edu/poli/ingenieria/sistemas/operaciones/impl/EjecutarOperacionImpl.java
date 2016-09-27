/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.poli.ingenieria.sistemas.operaciones.impl;

import co.edu.poli.ingenieria.sistemas.operaciones.EjecutarOperacion;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

/**
 *
 * @author andres.marulanda
 */
public class EjecutarOperacionImpl implements  EjecutarOperacion {

    @Override
    public double ejecutarOperacion(String operacion) throws  Exception{
        double d = 0;
        try {
            
        } catch (Exception e) {
            System.out.println("Error ejecutando operaciones : "+ e.getMessage());
        }
        return  d;
    }

    @Override
    public String resolverOperaciones(String operacion) throws Exception {
        try {
            String temporal = operacion;
            
            ScriptEngineManager opera = new ScriptEngineManager();
            ScriptEngine engine = opera.getEngineByName("JavaScript");
             return engine.eval(temporal.replace("%", "/100")).toString();
        } catch (Exception e) {
            System.out.println("Error casteando operacion"+ e.getMessage());
        }
        return operacion;

    }
    
}
