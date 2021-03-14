package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Currency {

    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    public final DecimalFormat dformat = new DecimalFormat("#.##");
    public final String item[] = {"BDT", "US Doller", "Euro"};
    public JLabel topLabel = new JLabel("CURRENCY CONVERTER");
    public JLabel lebel1 = new JLabel("Amount");
    public JLabel lebel2 = new JLabel("From ");
    public JLabel lebel3 = new JLabel("To ");
    public JTextField TextField = new JTextField();
    public JButton ConvertButton = new JButton("GET");
    public JButton clearButton = new JButton("CLEAR");
    public JComboBox from = new JComboBox(item);
    public JComboBox to = new JComboBox(item);
    public JTextArea info = new JTextArea("");

    public void CurrSec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        topLabel.setBounds(100, 10, 360, 40);
        topLabel.setFont(f.font[6]);

        lebel1.setBounds(130, 100, 150, 50);
        lebel1.setFont(f.font[2]);

        lebel2.setBounds(130, 150, 150, 50);
        lebel2.setFont(f.font[2]);

        lebel3.setBounds(130, 200, 150, 50);
        lebel3.setFont(f.font[2]);

        TextField.setBounds(250, 112, 120, 30);
        TextField.setToolTipText("Enter The Amount ");
        TextField.setFont(f.font[2]);
        TextField.setHorizontalAlignment(JTextField.CENTER);
        TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    double Result = 0, m = Double.parseDouble(TextField.getText());
                    String fitem = from.getSelectedItem().toString();
                    String titem = to.getSelectedItem().toString();
                    int i = 0, j, F = from.getSelectedIndex();
                    int T = to.getSelectedIndex();
                    if (F == T) {
                        JOptionPane.showMessageDialog(null, "Same Currency!", "Currency Converter", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (F == 0 && T == 1) {
                            Result = m / 84.69;
                        } else if (F == 1 && T == 0) {
                            Result = m * 84.69;
                        } else if (F == 0 && T == 2) {
                            Result = m / 104.20;
                        } else if (F == 2 && T == 0) {
                            Result = m * 104.2;
                        } else if (F == 1 && T == 2) {
                            Result = m * 0.82;
                        } else if (F == 2 && T == 1) {
                            Result = m * 1.23;
                        }
                        info.setText(m + " " + fitem + " = " + dformat.format(Result) + " " + titem);

                        JOptionPane.showMessageDialog(null, m + " " + fitem + " = " + dformat.format(Result) + " " + titem, "Currency Converter", -1, ic.icon[2]);
                    }
                } catch (Exception ex) {
                     TextField.setText("");
                    info.setText("");
                    JOptionPane.showMessageDialog(null, "Please Enter a Number!", "Currency Converter", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ConvertButton.setBackground(Color.white);
        ConvertButton.setBounds(135, 280, 100, 40);
        ConvertButton.setFont(f.font[1]);
        ConvertButton.setToolTipText("Click Here To Convert");
        ConvertButton.setCursor(cursor);
        ConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    double Result = 0, m = Double.parseDouble(TextField.getText());
                    String fitem = from.getSelectedItem().toString();
                    String titem = to.getSelectedItem().toString();
                    int i = 0, j, F = from.getSelectedIndex();
                    int T = to.getSelectedIndex();
                    if (F == T) {
                        JOptionPane.showMessageDialog(null, "Same Currency!", "Currency Converter", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (F == 0 && T == 1) {
                            Result = m / 84.69;
                        } else if (F == 1 && T == 0) {
                            Result = m * 84.69;
                        } else if (F == 0 && T == 2) {
                            Result = m / 104.20;
                        } else if (F == 2 && T == 0) {
                            Result = m * 104.2;
                        } else if (F == 1 && T == 2) {
                            Result = m * 0.82;
                        } else if (F == 2 && T == 1) {
                            Result = m * 1.23;
                        }
                        info.setText(m + " " + fitem + " = " + dformat.format(Result) + " " + titem);

                        JOptionPane.showMessageDialog(null, m + " " + fitem + " = " + dformat.format(Result) + " " + titem, "Currency Converter", -1, ic.icon[2]);
                    }
                } catch (Exception ex) {
                    TextField.setText("");
                    info.setText("");
                    JOptionPane.showMessageDialog(null, "Please Enter a Number!", "Currency Converter", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.setBackground(Color.white);
        clearButton.setBounds(255, 280, 100, 40);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TextField.setText("");
                info.setText("");
            }
        });
        clearButton.setFont(f.font[1]);
        clearButton.setCursor(cursor);
        clearButton.setToolTipText("Click Here To Convert");

        from.setToolTipText("Select Currency");
        from.setBounds(250, 160, 120, 30);
        from.setFont(f.font[1]);
        from.setSelectedIndex(0);
        from.setCursor(cursor);

        to.setToolTipText("Select Currency");
        to.setBounds(250, 210, 120, 30);
        to.setSelectedIndex(1);
        to.setFont(f.font[1]);
        to.setCursor(cursor);

        info.setBounds(140, 360, 450, 60);
        info.setEditable(false);
        info.setBackground(Color.decode("#EEEEEE"));
        info.setFont(f.font[5]);

    }

}
