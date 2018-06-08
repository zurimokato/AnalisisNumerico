/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingenieros
 */
public class NewtonRaphson {
    private int i = 0;
    private double e = 10;
    private ArrayList<Double> t=new ArrayList<>();
    private Funcion fun;

  
    
    public NewtonRaphson(double aprox_i,Funcion fun) {

        t.add(0,aprox_i);
        this.fun=fun;

    }
   

  
   
    public double errRel(int i){
        double e;
        e=Math.abs((t.get(i+1)-t.get(i))/t.get(i+1));
        e=e*100;
        return e;
    }
    
    
    public double errAbs(int i){
        double e;
        e=Math.abs((t.get(i+1)-t.get(i))/t.get(i+1));
        e=e*100;
        return e;
    }
   
    public void calcRaiz(DefaultTableModel model, int numI) {
        i = 0;
        model.setNumRows(0);
        double next;
        while (numI >i ) {
            next=t.get(i)-(fun.eval(t.get(i))/fun.derivate(t.get(i)));
            t.add(i+1,next);
            e =errRel(i);
            model.addRow(new Object[]{i,t.get(i),fun.eval(t.get(i)),fun.derivate(t.get(i)),e});
            i++;
        }

        
    }
    
     public void calcRaiz(DefaultTableModel model, double  err) {
        i = 0;
        model.setNumRows(0);
        double next;
        while (e >err ) {
            next=t.get(i)-(fun.eval(t.get(i))/fun.derivate(t.get(i)));
            t.add(i+1,next);
            e =errRel(i);
            model.addRow(new Object[]{i,t.get(i),fun.eval(t.get(i)),fun.derivate(t.get(i)),e});
            i++;
        }

        
    }

}
