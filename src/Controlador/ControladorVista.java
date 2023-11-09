/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Edo;
import Vista.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author WINDOWS 10
 */
public class ControladorVista implements ActionListener {
    
    Edo ObjEdo;
    VistaIngreso Vingreso;
    
    public ControladorVista() {
        ObjEdo = new Edo();
        Vingreso = new VistaIngreso();
        Vingreso.getBResolver().addActionListener(this);
    }
    
    public void MostrarVista() {
        Vingreso.setResizable(false);
        Vingreso.setTitle("Edo");
        Vingreso.setLocationRelativeTo(null);
        Vingreso.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String Ecuacion = Vingreso.getTxtEcuacion().getText();
        if (ae.getSource() == Vingreso.getBResolver()) {
            ObjEdo.extraerCoeficientes(Ecuacion);
            Vingreso.getAreaResultado().setText(ObjEdo.TodoLosPasos());
            
        }
    }
    
}
