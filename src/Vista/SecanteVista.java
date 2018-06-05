package Vista;

import Logica.Funcion;
import Logica.Secante;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingenieros
 */
public class SecanteVista extends JFrame {

    private JTextField exp;
    private JTextField limit1, limit2;
    private JTextField txt_parameter;
    private int selecion;
    private JTable table;
    private float limite1,limite2;
    private String s;
    private Funcion fun;

    public SecanteVista() {

        setTitle("Secante");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        setBounds(50, 50, 800, 400);

        JPanel setpanel = new JPanel();
        setpanel.setBounds(10, 11, 165, 291);
        getContentPane().add(setpanel);
        setpanel.setLayout(null);

        JLabel text = new JLabel("Escriba Una exprecion");
        text.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
        text.setBounds(10, 0, 180, 14);
        setpanel.add(text);
        exp = new JTextField();
        exp.setBounds(13, 16, 110, 20);
        setpanel.add(exp);
        exp.setColumns(10);

        limit1 = new JTextField();
        limit1.setBounds(13, 56, 110, 20);
        setpanel.add(limit1);
        limit1.setColumns(10);

        JLabel lblLimit1 = new JLabel("Limite 1");
        lblLimit1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        lblLimit1.setBounds(10, 36, 46, 14);
        setpanel.add(lblLimit1);

        limit2 = new JTextField();
        limit2.setBounds(13, 106, 110, 20);
        setpanel.add(limit2);
        limit2.setColumns(10);

        JLabel lblLimit2 = new JLabel("Limite 2");
        lblLimit2.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        lblLimit2.setBounds(10, 86, 46, 14);
        setpanel.add(lblLimit2);

        txt_parameter = new JTextField();
        txt_parameter.setBounds(13, 240, 110, 20);
        setpanel.add(txt_parameter);
        txt_parameter.setColumns(10);
        txt_parameter.setVisible(false);

         final JLabel lbl_parameter = new JLabel("Num iteraciones");
        lbl_parameter.setVisible(false);
        lbl_parameter.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        lbl_parameter.setBounds(13, 225, 142, 14);
        setpanel.add(lbl_parameter);

        JRadioButton sl_iterations = new JRadioButton("Iteraciones");
        sl_iterations.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        sl_iterations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt_parameter.setVisible(true);
                selecion = 1;
                lbl_parameter.setVisible(true);
                lbl_parameter.setText("Iteraciones");

            }
        });
        sl_iterations.setBounds(13, 133, 109, 23);
        setpanel.add(sl_iterations);

       

        JRadioButton sl_relerr = new JRadioButton("Error relativo");
        sl_relerr.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        sl_relerr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txt_parameter.setVisible(true);
                lbl_parameter.setVisible(true);
                selecion = 2;
                lbl_parameter.setText("Error deseado");
            }
        });
        sl_relerr.setBounds(14, 153, 109, 23);
        setpanel.add(sl_relerr);
        ButtonGroup select = new ButtonGroup();
        select.add(sl_iterations);
        select.add(sl_relerr);
        
        
        
        JButton btnStart = new JButton("Calcular");
        btnStart.setBounds(43, 313, 89, 23);
        getContentPane().add(btnStart);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(185, 11, 599, 291);
        getContentPane().add(scrollPane);
        
        final DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Iteracion");
        model.addColumn("x_i-1");
        model.addColumn("f(x_i-1)");
        model.addColumn("x_i");
        model.addColumn("f(x_i)");
        model.addColumn("x_i+1");
        model.addColumn("f(x_i+1)");
        model.addColumn("Error Absoluto");
        table.getColumnModel().getColumn(3).setPreferredWidth(79);
        scrollPane.setViewportView(table);
        
        
       
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if (exp.getText().length() == 0 || limit1.getText().length() == 0
                        || limit2.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios");

                } else {
                     s = exp.getText();
                    limite1 = Float.parseFloat(limit1.getText());
                    limite2 = Float.parseFloat(limit2.getText());
                    fun = new Funcion(s);
                    final Secante sec = new Secante(limite1, limite2, fun);
                    if(txt_parameter.getText().length()==0){
                            JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios");
                    }else{
                        switch(selecion){
                            case 1:
                                int numi=Integer.parseInt(txt_parameter.getText());
                                sec.calcRaiz(model, numi);
                                break;
                            case 2:
                                double errRel = Double.parseDouble(txt_parameter.getText());
                                sec.calcRaiz(model,errRel);
                                break;
                        }
                    }
                    
                 }
            }
        });

    }

}
