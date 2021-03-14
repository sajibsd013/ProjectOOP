package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Temperature {

    public JLabel label[];
    public final DecimalFormat dformat = new DecimalFormat("#.##");
    public double t, a1, a2;
    public int Dvalue[] = {0, 32, 273};
    public JTextField TempField[];
    public final String TempItem[] = {"Celsius", "Farenheit", "Kelvin", "℃", "℉", "K"};
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    public JLabel topLabel = new JLabel("TEMPERATURE CONVERTER");
    public JButton TempclearButton = new JButton("RESET");
    public JSlider slider[];

    public void temoSec() {

        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        topLabel.setBounds(90, 10, 360, 40);
        topLabel.setFont(f.font[6]);

        slider = new JSlider[3];
        label = new JLabel[9];
        TempField = new JTextField[3];

        slider[0] = new JSlider(JSlider.VERTICAL, -90, 100, 0);
        slider[0].setMajorTickSpacing(10);
        slider[1] = new JSlider(JSlider.VERTICAL, -130, 212, 32);
        slider[1].setMajorTickSpacing(18);
        slider[2] = new JSlider(JSlider.VERTICAL, 183, 373, 273);
        slider[2].setMajorTickSpacing(10);

        int pos = 60, pos2 = 60, lf = 220, lf2 = 240;
        for (int i = 0; i < 9; i++) {
            pos += 50;
            label[i] = new JLabel();
            if (i < 3) {
                // Label 
                label[i].setFont(f.font[2]);
                label[i].setBounds(40, pos, 300, 30);
                label[i].setText(TempItem[i]);

                // Textfield
                TempField[i] = new JTextField("");
                TempField[i].setBounds(120, pos, 120, 30);
                TempField[i].setVisible(true);
                TempField[i].setFont(f.font[0]);
                TempField[i].setHorizontalAlignment(JTextField.CENTER);

                //slider 
                lf += 65;
                slider[i].setBounds(lf, 50, 75, 340);
                slider[i].setMinorTickSpacing(3);
                slider[i].setPaintTicks(true);
                slider[i].setPaintLabels(true);
                slider[i].setEnabled(false);
            } else if (i < 6) {
                lf2 += 65;
                label[i].setFont(f.font[1]);
                label[i].setBounds(lf2, 390, 30, 30);
                label[i].setText(TempItem[i]);
            } else {
                pos2 += 50;
                label[i].setFont(f.font[1]);
                label[i].setBounds(245, pos2, 30, 30);
                label[i].setText(TempItem[i - 3]);
            }
        }

        slider[0].addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent ce) {
                t = slider[0].getValue();
                a1 = (t * 9 / 5) + 32;
                a2 = t + 273.15;
                slider[1].setValue((int) a1);
                slider[2].setValue((int) a2);
            }
        });

        TempField[0].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                try {
                    t = Double.parseDouble(TempField[0].getText());
                    a1 = (t * 9 / 5) + 32;
                    a2 = t + 273.15;
                    TempField[1].setText(String.valueOf(dformat.format(a1)));
                    TempField[2].setText(String.valueOf(dformat.format(a2)));
                    slider[0].setValue((int) t);
                } catch (Exception ex) {
                    if (TempField[0].getText().isEmpty()) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Number!", "TEMPERATURE CONVERTER", JOptionPane.ERROR_MESSAGE);
                        for (int i = 0; i < 3; i++) {
                            TempField[i].setText("");
                            slider[i].setValue(Dvalue[i]);
                        }
                    }

                }
            }
        });

        TempField[1].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                try {
                    t = Double.parseDouble(TempField[1].getText());
                    a1 = (t - 32) * 5 / 9;
                    a2 = (t - 32) * 5 / 9 + 273.15;
                    TempField[0].setText(String.valueOf(dformat.format(a1)));
                    TempField[2].setText(String.valueOf(dformat.format(a2)));
                    slider[0].setValue((int) a1);
                } catch (Exception ex) {
                    if (TempField[1].getText().isEmpty()) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Number!", "TEMPERATURE CONVERTER", JOptionPane.ERROR_MESSAGE);
                        for (int i = 0; i < 3; i++) {
                            TempField[i].setText("");
                            slider[i].setValue(Dvalue[i]);
                        }
                    }

                }
            }
        });

        TempField[2].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                try {
                    t = Double.parseDouble(TempField[2].getText());
                    a1 = t - 273.15;
                    a2 = ((t - 273.15) * 9 / 5) + 32;
                    TempField[0].setText(String.valueOf(dformat.format(a1)));
                    TempField[1].setText(String.valueOf(dformat.format(a2)));
                    slider[0].setValue((int) a1);
                } catch (Exception ex) {
                    if (TempField[2].getText().isEmpty()) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Number!", "TEMPERATURE CONVERTER", JOptionPane.ERROR_MESSAGE);
                        for (int i = 0; i < 3; i++) {
                            TempField[i].setText("");
                            slider[i].setValue(Dvalue[i]);
                        }
                    }

                }
            }
        });

        TempclearButton.setBackground(Color.decode("#ffffff"));
        TempclearButton.setBounds(80, 270, 150, 40);
        TempclearButton.setCursor(cursor);
        TempclearButton.setFont(f.font[1]);
        TempclearButton.setToolTipText("Click Here To Convert");
        TempclearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < 3; i++) {
                    TempField[i].setText("");
                    slider[i].setValue(Dvalue[i]);
                }
            }
        });
        
        
        

    }

}
