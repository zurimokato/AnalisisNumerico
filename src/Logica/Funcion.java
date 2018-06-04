
package Logica;

import org.nfunk.jep.JEP;

/**
 *
 * @author Ingenieros
 */
public class Funcion {
    JEP j=new JEP();
    
    public Funcion(String exp){
        j.addVariable("x", 0);
        j.parseExpression(exp);
        if(j.hasError()){
            System.out.println(j.getErrorInfo());
        }
        j.addStandardConstants();
        j.addStandardFunctions();
        
    }
    
    
    public double eval(double x){
        double e=0;
        j.addVariable("x", x);
        e=j.getValue();
        if(j.hasError()){
            System.out.println(j.getErrorInfo());
        }
        return e;
    }
    
}
