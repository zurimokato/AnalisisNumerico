/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import Logica.NewtonRapson;
import Vista.BisecWindows;
import java.awt.EventQueue;
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
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BisecWindows frame = new BisecWindows();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
}
