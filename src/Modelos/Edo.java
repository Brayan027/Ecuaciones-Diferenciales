/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author WINDOWS 10
 */
public class Edo {

    private int a;
    private int b;
    private int c;
    private float y1;
    private float y2;
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    private int Determinante() {
        return (int) ((Math.pow(getB(), 2)) - (4 * getA() * getC()));
    }

    public void extraerCoeficientes(String ecuacion) {
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        String[] terminos = ecuacion.split("\\+");
        for (String termino : terminos) {
            termino = termino.trim().replaceAll(" ", "");

            if (termino.contains("y''")) {
                int signo = 1;
                if (termino.startsWith("-")) {
                    signo = -1;
                    termino = termino.substring(1);
                }
                int coeficiente = 1;
                if (!termino.equals("y''")) {
                    try {
                        coeficiente = Integer.parseInt(termino.substring(0, termino.indexOf("y''")));
                    } catch (NumberFormatException e) {
                    }
                }
                a += signo * coeficiente;

            } else if (termino.contains("y'")) {
                int signo = 1;
                if (termino.startsWith("-")) {
                    signo = -1;
                    termino = termino.substring(1);
                }
                int coeficiente = 1;
                if (!termino.equals("y'")) {
                    try {
                        coeficiente = Integer.parseInt(termino.substring(0, termino.indexOf("y'")));
                    } catch (NumberFormatException e) {
                    }
                }
                b += signo * coeficiente;

            } else if (termino.contains("y")) {
                int signo = 1;
                if (termino.startsWith("-")) {
                    signo = -1;
                    termino = termino.substring(1);
                }
                int coeficiente = 1;
                if (!termino.equals("y")) {
                    try {
                        coeficiente = Integer.parseInt(termino.substring(0, termino.indexOf("y")));
                    } catch (NumberFormatException e) {
                    }
                }
                c += signo * coeficiente;
            }
        }
        setA((int) a);
        setB((int) b);
        setC((int) c);

    }

    public String simplificarEcuacion() {
        String ecuacionFinal = getA() + "m^2" + " " + "" + "+" + getB() + "m" + "" + "+" + getC();

        return ecuacionFinal;
    }

    private String PasosParaObtenerY() {
        String tex = "";
        if (Determinante() > 0) {
            tex = "\n(b^2 - 4ac) > 0, lo que significa que tenemos dos raíces reales distintas, y1 ≠ y2."
                    + "\n"
                    + "Procedemos a encontrar el valor de y1 y y2:"
                    + "\n"
                    + "Calculamos y1: y1 = -(" + getB() + ") + " + valorDeterminate() + " / (2 * " + getA() + ") = " + getY1()
                    + "\n"
                    + "Calculamos y2: y2 = -(" + getB() + ") - " + valorDeterminate() + " / (2 * " + getA() + ") = " + getY2()
                    + "\n"
                    + "La solución toma la forma y = c1 * e^" + "y1t+" + " " + "c2 e^y2 t"
                    + "\n"
                    + "Reemplazando los valores de y1 y y2 obtenemos:";
        } else if (Determinante() == 0) {
            tex = "(b^2 - 4ac) = 0, tenemos una única raíz real, y1 = y2."
                    + "\n"
                    + "Procedemos a encontrar el valor de y ya que y1=y2:"
                    + "\n"
                    + "Calculamos y: y = -(" + getB() + ") " + " / (2 * " + getA() + ") = " + getY1()
                    + "\nDonde y abarca a las dos soluciones"
                    + "\n"
                    + "La solución toma la forma y = c1 * e^yt +c2te^yt"
                    + "\n"
                    + "Reemplazando los valores de y obtenemos:";

        } else {
            tex = "\n(b^2 - 4ac) < 0, tenemos dos raíces complejas conjugadas."
                    + "\n"
                    + "Procedemos a encontrar el valor de y1 y y2:"
                    + "\n"
                    + "Calculamos y1: y1 = -(" + getB() + ") + " + valorDeterminate() + " / (2 * " + getA() + ") = " + getY1()
                    + "\n"
                    + "Calculamos y2: y2 = -(" + getB() + ") - " + valorDeterminate() + " / (2 * " + getA() + ") = " + getY2()
                    + "\n"
                    + "La solución toma la forma y = e^(αt) * (c1 * cos(βt) + c2 * sin(βt))"
                    + "\n"
                    + "Reemplazando los valores de y1 y y2 obtenemos:";
        }

        return tex;
    }

    public String TodoLosPasos() {
        SolucionFinal();
        String pasos = "        *** Pasos para la solución ***         "
                + "\n"
                + "Resolución de una ecuación diferencial lineal de segundo orden con coeficientes constantes:" + "\n ay'' + by' + c = 0"
                + "\n"
                + "-- Se plantea una solución auxiliar: " + simplificarEcuacion()
                + "\n"
                + "Luego, procedemos a resolver la ecuación cuadrática de segundo orden:"
                + "\n"
                + "-b ± √(b^2 - 4ac) / (2a)"
                + "\n"
                + "Reemplazando:"
                + "\n"
                + "-(" + getB() + ") ± √(" + getB() + "^2 - 4(" + getA() + "*" + getC() + ")) / (2 * " + getA() + ")"
                + "\nAhora nos fijamos en el resultado de " + "" + "(b^2 - 4ac)"
                + "\nEn este caso el " + " " + "" + getB() + "^2 - 4(" + getA() + "*" + getC() + ")" + "=" + " " + Math.sqrt(Determinante())
                + PasosParaObtenerY()
                + getTexto();

        return pasos;
    }

    private double valorDeterminate() {
        return Math.sqrt(Determinante());
    }

    public void SolucionFinal() {

        if (Determinante() > 0) {
            float valory1 = (-(getB()) + (float) valorDeterminate()) / (2 * getA());
            setY1(valory1);
            float valory2 = (-(getB()) - (float) valorDeterminate()) / (2 * getA());
            setY2(valory2);
            texto = "\nResultado:" + ("y=c1e^" + getY1() + "t" + "+" + " " + "c2e^" + getY2() + "t");
        } else if (Determinante() == 0) {

            float valory1 = -getB() / (2 * getA());
            setY1(valory1);
            setY2(valory1);
            texto = "\nResultado:" + ("y= c1e^" + getY1() + "t" + "+" + " " + "c2te^" + getY2() + "t");
        } else {
            float parteReal = -getB() / (2 * getA());
            float parteImaginaria = (float) Math.sqrt(-Determinante()) / (2 * getA());
            texto = "\nResultado:" + ("y = e^(" + parteReal + "t) * (c1 * cos(" + parteImaginaria + "t) + c2 * sin(" + parteImaginaria + "t))");
        }
    }

}
