/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ingenieros
 */
public class NewtonRapsonVista extends JFrame {

    public NewtonRapsonVista() {

        setTitle("Analisis Numerico Aproximación de raices");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        setBounds(50, 50, 800, 400);

        JPanel setpanel = new JPanel();
        setpanel.setBounds(10, 11, 165, 291);
        getContentPane().add(setpanel);
        setpanel.setLayout(null);

    }

}
