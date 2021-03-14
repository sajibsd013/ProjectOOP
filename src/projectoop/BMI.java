package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BMI {

    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    public final DecimalFormat dformat = new DecimalFormat("#.###");
    public JLabel BMIlebel[];
    public String BMIS[] = {"Height", "Weight", "cm", "kg","BMI CALCULATOR"};
    public String BMIb[] = {"GET", "CLEAR"};
    public JTextField BMIField[];
    public JButton BMIButton[];
    public JTextArea information = new JTextArea("");

    public void BMIsec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        BMIlebel = new JLabel[5];
        BMIField = new JTextField[2];
        BMIButton = new JButton[2];
        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                BMIField[i] = new JTextField();
                BMIField[i].setFont(f.font[0]);
                BMIField[i].setHorizontalAlignment(JTextField.CENTER);

                BMIButton[i] = new JButton("" + BMIb[i]);
                BMIButton[i].setFont(f.font[1]);
                BMIButton[i].setCursor(cursor);
                BMIButton[i].setBackground(Color.white);
            }
            BMIlebel[i] = new JLabel("" + BMIS[i]);
            BMIlebel[i].setFont(f.font[2]);
        }
        BMIlebel[0].setBounds(120, 170, 160, 50);
        BMIlebel[1].setBounds(120, 100, 160, 50);
        BMIlebel[2].setBounds(360, 170, 160, 50);
        BMIlebel[3].setBounds(360, 100, 160, 50);
        BMIlebel[4].setBounds(130, 10, 300, 40);
        BMIlebel[4].setFont(f.font[6]);

        BMIField[0].setBounds(230, 110, 120, 30);
        BMIField[0].setToolTipText("Enter The Height ");
        BMIField[1].setBounds(230, 180, 120, 30);
        BMIField[1].setToolTipText("Enter The Weight ");

        BMIButton[0].setBounds(130, 240, 100, 40);
        BMIButton[0].setToolTipText("Click Here To Convert");
        BMIButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double Result, h, w;
                    w = Double.parseDouble(BMIField[0].getText());
                    h = Double.parseDouble(BMIField[1].getText())/100;

                    Result = w / (h * h);

                    if (Result <= 18.5) {
                        information.setText("Your BMI is " + dformat.format(Result) + " . This is consired Underweight.");
                    } else if (Result <= 24.9) {
                        information.setText("Your BMI is " + dformat.format(Result) + " . This is consired Normal.");
                    } else if (Result <= 29.9) {
                        information.setText("Your BMI is " + dformat.format(Result) + " . This is consired Overweight.");
                    } else {
                        information.setText("Your BMI is " + dformat.format(Result) + " . This is consired Obese.");
                    }

                    JOptionPane.showMessageDialog(null, " Your BMI is " + dformat.format(Result), "BMI CALCULATOR", -1, ic.icon[2]);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Number!", "BMI CALCULATOR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        BMIButton[1].setBounds(250, 240, 100, 40);
        BMIButton[1].setToolTipText("Click Here To Convert");
        BMIButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                information.setText("");
                BMIField[0].setText("");
                BMIField[1].setText("");
            }
        });

        information.setBounds(70, 330, 450, 60);
        information.setEditable(false);
        information.setBackground(Color.decode("#EEEEEE"));
        information.setFont(f.font[5]);

        

    }
}
