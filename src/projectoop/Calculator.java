package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculator {

    public JTextField field = new JTextField();
    public JButton b[], b1[];
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    public final DecimalFormat dformat = new DecimalFormat("#.#####");
    public String EnterNumber, Operations, Ans;
    public double num1, num2, abc;
    public int j;

    public void CalSec() {
        action ac = new action();
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        field.setBounds(20, 80, 195, 40);
        field.setEditable(false);
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setBackground(Color.white);
        field.setFont(f.font[1]);

        b = new JButton[20];
        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                b[i] = new JButton("" + i);
            } else {
                b[i] = new JButton();
            }

            b[i].setPreferredSize(new Dimension(45, 45));
            b[i].setVisible(true);
            b[i].setCursor(cursor);
            b[i].setBackground(Color.white);
            b[i].setFont(f.font[1]);
            b[i].setEnabled(false);
        }
        b[10].setText(".");

        b[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[0].getText());
            }
        });
        b[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[1].getText());
            }
        });
        b[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[2].getText());
            }
        });
        b[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[3].getText());
            }
        });
        b[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[4].getText());
            }
        });
        b[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[5].getText());
            }
        });
        b[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[6].getText());
            }
        });
        b[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[7].getText());
            }
        });
        b[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[8].getText());
            }
        });
        b[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[9].getText());
            }
        });
        b[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText(field.getText() + b[10].getText());
            }
        });

        b[11].setText("±");
        b[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    abc = Double.parseDouble(field.getText());
                    abc *= -1;
                    field.setText(String.valueOf(abc));
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b[12].setText("+");
        b[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    num1 = Double.parseDouble(field.getText());
                    field.setText("");
                    Operations = "+";
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b[13].setText("-");
        b[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    num1 = Double.parseDouble(field.getText());
                    field.setText("");
                    Operations = "-";
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b[14].setText("×");
        b[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    num1 = Double.parseDouble(field.getText());
                    field.setText("");
                    Operations = "*";
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b[15].setText("/");
        b[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    num1 = Double.parseDouble(field.getText());
                    field.setText("");
                    Operations = "/";
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b[16].setText("√");
        b[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.sqrt(sr)));
                    field.setText(String.valueOf(Ans));
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b[17].setText("=");
        b[17].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    num2 = Double.parseDouble(field.getText());
                    field.setText("");
                    switch (Operations) {
                        case "+":
                            Ans = String.valueOf(dformat.format(num2 + num1));
                            field.setText(Ans);
                            break;
                        case "-":
                            Ans = String.valueOf(dformat.format(num1 - num2));
                            field.setText(Ans);
                            break;
                        case "*":
                            Ans = String.valueOf(dformat.format(num1 * num2));
                            field.setText(Ans);
                            break;
                        case "/":
                            Ans = String.valueOf(dformat.format(num1 / num2));
                            field.setText(Ans);
                            break;
                        case "^":
                            Ans = String.valueOf(dformat.format(Math.pow(num1, num2)));
                            field.setText(Ans);
                            break;
                    }
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }

        });

        b[18].setText("C");
        b[18].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                field.setText("");
            }
        });

        b[19].setText("‹");
        b[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    StringBuilder str = new StringBuilder(field.getText());
                    int len = str.length();
                    String s = str.deleteCharAt(len - 1).toString();
                    field.setText(s);
                } catch (Exception ex) {
                    field.setText("Error");
                }
            }
        });

        // Sci Mode
        b1 = new JButton[21];
        for (int i = 0; i < 21; i++) {
            b1[i] = new JButton();
            b1[i].setPreferredSize(new Dimension(65, 45));
            b1[i].setVisible(true);
            b1[i].setCursor(cursor);
            b1[i].setBackground(Color.white);
            b1[i].setFont(f.font[1]);
        }

        b1[0].setText("π");
        b1[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    field.setText(field.getText() + Math.PI);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });
        b1[1].setText("x²");
        b1[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.pow(sr, 2)));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[2].setText("x³");
        b1[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.pow(sr, 3)));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[3].setText("^");
        b1[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    num1 = Double.parseDouble(field.getText());
                    field.setText("");
                    Operations = "^";
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[4].setText("log");
        b1[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.log10(sr)));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[5].setText("sin");
        b1[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.sin(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[6].setText("cos");
        b1[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.cos(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[7].setText("tan");
        b1[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.tan(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[8].setText("csc");
        b1[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / Math.sin(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[9].setText("sec");
        b1[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / Math.cos(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[10].setText("cot");
        b1[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / Math.tan(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[11].setText("sinh");
        b1[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.sinh(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[12].setText("cosh");
        b1[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.cosh(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[13].setText("tanh");
        b1[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.tanh(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[14].setText("csch");
        b1[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / Math.sinh(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[15].setText("sech");
        b1[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / Math.cosh(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[16].setText("coth");
        b1[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / Math.tanh(Math.toRadians(sr))));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[17].setText("n!");
        b1[17].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int n = Integer.parseInt(field.getText());
                    int fact = 1;
                    for (int i = 2; i <= n; i++) {
                        fact *= i;
                    }
                    field.setText(String.valueOf(fact));
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[18].setText("¹/x");
        b1[18].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(1 / sr));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[19].setText("³√");
        b1[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(Math.cbrt(sr)));
                    field.setText(String.valueOf(Ans));
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

        b1[20].setText("%");
        b1[20].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double sr = Double.parseDouble(field.getText());
                    Ans = String.valueOf(dformat.format(sr / 100));
                    field.setText(Ans);
                } catch (Exception ex) {
                    field.setText(ex.getMessage());
                }
            }
        });

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Calculator Section
            for (int i = 0; i < 11; i++) {
                if (ae.getSource() == b[i]) {
                    field.setText(field.getText() + b[i].getText());
                }
            }
        }

    }

}
