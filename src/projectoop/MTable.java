package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MTable {

    public JLabel label1 = new JLabel("MULTIPLICATION TABLE");
    public JLabel label2 = new JLabel("Enter any Number ");
    public SpinnerNumberModel value = new SpinnerNumberModel(1, 1, 99999, 1);
    public JSpinner mfield = new JSpinner(value);
    public JButton clear = new JButton("CLEAR");
    public JButton get = new JButton("GET");
    public JTextArea area = new JTextArea();
    public Cursor cursor =new Cursor(Cursor.HAND_CURSOR);

    public void MTsec() {
    
        
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        label1.setBounds(100, 10, 380, 40);
        label1.setFont(f.font[6]);

        label2.setBounds(30, 150, 260, 40);
        label2.setFont(f.font[1]);

        mfield.setBounds(160, 150, 60, 40);
        mfield.setFont(f.font[1]);
        mfield.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent ce) {
                try {
                    area.setText("");
                    int num = (int) mfield.getValue();
                    for (int i = 1; i <= 10; i++) {
                        int result = num * i;
                        String r = String.valueOf(result);
                        String n = String.valueOf(num);
                        String x = String.valueOf(i);
                        area.append(n + " × " + x + " = " + r + "\n");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Number!", "MULTIPLICATION TABLE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        area.setBounds(280, 70, 450, 500);
        area.setEditable(false);
        area.setBackground(Color.decode("#EEEEEE"));
        area.setFont(f.font[7]);

        get.setBounds(25, 250, 100, 40);
        get.setFont(f.font[1]);
        get.setCursor(cursor);
        get.setBackground(Color.decode("#ffffff"));
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    area.setText("");
                    int num = (int) mfield.getValue();
                    for (int i = 1; i <= 10; i++) {
                        int result = num * i;
                        String r = String.valueOf(result);
                        String n = String.valueOf(num);
                        String x = String.valueOf(i);
                        area.append(n + " x " + x + " = " + r + "\n");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Number!", "MULTIPLICATION TABLE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clear.setBounds(140, 250, 100, 40);
        clear.setFont(f.font[1]);
        clear.setCursor(cursor);
        clear.setBackground(Color.decode("#ffffff"));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mfield.setValue(1);
                area.setText("");

            }
        });
        
        
    
    }

}
