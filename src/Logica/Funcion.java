
package Logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author Ingenieros
 */
public class Funcion {
    private JEP j=new JEP();
    private String exp;
    
    public Funcion(String exp){
        this.exp=exp;
        j.addVariable("x", 0);
        j.addStandardConstants();
        j.addStandardFunctions();
        j.addComplex();
         j.parseExpression(exp);
        if(j.hasError()){
            JOptionPane.showMessageDialog(null, j.getErrorInfo());
    
            System.out.println(j.getErrorInfo());
        }
        
        
        
    }
    
    
    public double eval(double x){
        double e=0;
        j.addVariable("x", x);
        e=j.getValue();
        if(j.hasError()){
            JOptionPane.showMessageDialog(null, j.getErrorInfo());
            System.out.println(j.getErrorInfo());
        }
        return e;
    }
    
     public double derivate(Double xi) {
        double value=Double.NaN;
        DJep d = new DJep();
        String derivate="";
        d.addStandardConstants();
        d.addStandardFunctions();
        d.addComplex();
        d.setAllowUndeclared(true);
        d.setAllowAssignment(true);
        d.setImplicitMul(true);
        d.addStandardDiffRules();
        d.addVariable("x", xi);
        try {

            Node node = d.parse(exp);
            Node diff = d.differentiate(node, "x");
           
            Node simp = d.simplify(diff);
            
            d.parseExpression(simp.toString());
            
            value=(Double) d.evaluate(simp);           
            
        } catch (ParseException ex) {
            if(d.hasError())
            JOptionPane.showMessageDialog(null, d.getErrorInfo());
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
}
