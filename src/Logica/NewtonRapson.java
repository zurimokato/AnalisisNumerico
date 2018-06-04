/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Ingenieros
 */
public class NewtonRapson {
    int i = 0;
    double x[] = new double[50];
    double e = 10;

    public NewtonRapson(double aprox_i) {

        x[0] = aprox_i;

    }
   

   public double f(double x) {
        double fx;
        //Math.pow(valorx,3)+4*Math.pow(valorx,2)-10;
        fx = Math.pow(x,3)+4*Math.pow(x,2)-10;
        return fx;

    }

   public double fp(double x) {

        double fpx;
        
        fpx = 3*Math.pow(x,2)+8*x;
        return fpx;
    }

   public double calcRaiz() {
        i = 0;
        while (e > 0.0001) {
            x[i + 1] = x[i] - (f(x[i]) / fp(x[i]));
            e = Math.abs((x[i + 1] - x[i]) / x[i + 1]);
            e = e * 100;
            System.out.println("raiz=" + x[i] + "  Error=" + e);
            System.out.println("\n");
            i++;
        }

        return (x[i]);
    }

}
