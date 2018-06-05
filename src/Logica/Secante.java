package Logica;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingenieros
 */
public class Secante {

    private ArrayList<Double> x = new ArrayList<>();
    private double x0, x1;
    private double r;
    private double e = 10;
    private Funcion fun = null;

    public Secante(double x0, double x1, Funcion fun) {
        x.add(0, x0);
        x.add(1, x1);
        this.fun = fun;

    }

    public double errRel(int i) {
        double e = Double.NaN;
        e = Math.abs((x.get(i + 1) - x.get(i)) / (x.get(i + 1))) * 100;
        return e;
    }

    public double errAbs(int i) {
        double e = Double.NaN;
        e = Math.abs((x.get(i + 1) - x.get(i)) / (x.get(i + 1)));
        return e;
    }

    public void calcRaiz(DefaultTableModel model, double er) {
//este método define el proceso para calcular la raiz
        model.setNumRows(0);
        int i = 1;
        while (e > er) {
            double p = x.get(i) - ((fun.eval(x.get(i)) * (x.get(i - 1) - x.get(i)))
                    / (fun.eval(x.get(i - 1)) - fun.eval(x.get(i))));
            x.add(i + 1, p);
            e = errRel(i);
            model.addRow(new Object[]{i - 1, x.get(i - 1), fun.eval(x.get(i - 1)), x.get(i), fun.eval(x.get(i)),
                p, fun.eval(p), e});

            System.out.println(x.get(i + 1) + " \t" + e + "\n");
            i++;

        }

    }

    public void calcRaiz(DefaultTableModel model, int numI) {
//este método define el proceso para calcular la raiz
        model.setNumRows(0);
        int i = 1;
        while (numI > i) {
            double p = x.get(i) - ((fun.eval(x.get(i)) * (x.get(i - 1) - x.get(i)))
                    / (fun.eval(x.get(i - 1)) - fun.eval(x.get(i))));
            x.add(i + 1, p);
            e = errRel(i);
            e = errRel(i);
            model.addRow(new Object[]{i - 1, x.get(i - 1), fun.eval(x.get(i - 1)), x.get(i), fun.eval(x.get(i)),
                p, fun.eval(p), e});

            System.out.println(x.get(i + 1) + " \t" + e + "\n");
            i++;

        }

    }

}
