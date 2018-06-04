/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import Logica.NewtonRapson;
import java.util.Scanner;

/**
 *
 * @author Ingenieros
 */
public class AnalisisNumerico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         double r;
        NewtonRapson n1=null;
        Scanner lee=new Scanner(System.in);
        System.out.println("Introduce un valor para x_0=>");
        double x=lee.nextDouble();
        
        n1 = new NewtonRapson(x);
       
        r = n1.calcRaiz();
        System.out.println("Raiz="+r);
        
    }
    
}
