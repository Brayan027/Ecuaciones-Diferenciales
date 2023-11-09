/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controlador.ControladorVista;

/**
 *
 * @author WINDOWS 10
 */
public class main {

    public static void main(String[] args) {
        ControladorVista c = new ControladorVista();
        c.MostrarVista();
        /*   Edo edo = new Edo();
        String ecuacion = "2y''+5y'+3y = 0";
        edo.extraerCoeficientes(ecuacion);
        edo.calcularRaiz();
        //   System.out.println( edo.simplificarEcuacion(ecuacion));*/
    }
}
