package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;

/**
 *
 * @Sajib Sutradhar (190103020013)
 */
public class ProjectOOP extends JFrame {

    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    public JPanel panel[], CalPanel[], LogPanel[];
    public int i, k;
    public String ID1, Pass1, ID2, Pass2, path;
    public JMenuBar menubar;
    public JMenu menu[];
    public String menuList[] = {"Calculator", "Converter", "Help"};
    public JMenuItem menuitem[];
    public JButton MenuButton[], ConMenuButton[];
    public JToggleButton OnOff = new JToggleButton("Off", true);
    public JToggleButton SciMode = new JToggleButton("Scientific (Off)", true);
      public JTabbedPane TPanel, ConTPanel;
    public String menuS[] = {"Calculator", "BMI Calculator", "Multiplication Table", "Temperature Converter", "Currency Converter", "About", "Contact", "Chat Bot", "Start Page", "Logout"};

    public ProjectOOP() {
        components();
    }

    public void components() {

        //Icon Section
        final IconList ic = new IconList();
        ic.il();

        // Font Section
        final FontList f = new FontList();
        f.fl();
        // File 

        File CreteFile = new File("Login");
        CreteFile.mkdir();
        path = CreteFile.getAbsolutePath();

        // Software Icon
        this.setIconImage(ic.icon[0].getImage());
        
        //Main JFrame Section
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Java Project");

        panel = new JPanel[10];
        for (i = 0; i < 10; i++) {
            panel[i] = new JPanel();
            panel[i].setLayout(null);
            panel[i].setBounds(0, 0, 500, 500);
            panel[i].setVisible(false);
            this.add(panel[i]);
        }
        panel[0].setVisible(true);

        LogPanel = new JPanel[4];
        for (i = 0; i < 3; i++) {
            LogPanel[i] = new JPanel();
            LogPanel[i].setLayout(null);
            LogPanel[i].setBounds(0, 0, 500, 500);
            LogPanel[i].setVisible(false);
            panel[0].add(LogPanel[i]);
        }
        LogPanel[0].setVisible(true);

        //LoginPage
        final LoginPage l = new LoginPage();
        l.LogSec();
        for (i = 0; i < 7; i++) {
            LogPanel[0].add(l.LoginLabel[i]);
        }
        LogPanel[0].add(l.showPassButton);

        LogPanel[0].add(l.LogField);
        LogPanel[0].add(l.passField);
        LogPanel[0].add(l.SpassField);
        LogPanel[0].add(l.LoginButton);

        //Create page
        final CreatePage cl = new CreatePage();
        cl.CreateSec();

        for (i = 0; i < 8; i++) {
            if (i < 2) {
                LogPanel[1].add(cl.SpassField[i]);

                LogPanel[1].add(cl.passField[i]);
                LogPanel[1].add(cl.showPassButton[i]);
            }
            LogPanel[1].add(cl.CreateLabel[i]);
        }
        LogPanel[1].add(cl.LogField);
        LogPanel[1].add(cl.CreatButton);

        cl.CreateLabel[6].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                LogPanel[0].setVisible(true);
                LogPanel[1].setVisible(false);
                LogPanel[2].setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        final ResetPass rs = new ResetPass();
        rs.RSec();
        LogPanel[2].add(rs.resetButton);
        LogPanel[2].add(rs.resetField);
        LogPanel[2].add(rs.ResetLabel[0]);
        LogPanel[2].add(rs.ResetLabel[1]);
        LogPanel[2].add(rs.ResetLabel[2]);
        LogPanel[2].add(rs.ResetLabel[3]);
        LogPanel[2].add(rs.ResetLabel[4]);
        rs.ResetLabel[2].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                LogPanel[0].setVisible(true);
                LogPanel[1].setVisible(false);
                LogPanel[2].setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        rs.ResetLabel[3].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                LogPanel[0].setVisible(false);
                LogPanel[1].setVisible(true);
                LogPanel[2].setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        rs.resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    ID1 = rs.resetField.getText();

                    File filein = new File(path + "/" + ID1 + ".bin");
                    Scanner sc = new Scanner(filein);
                    while (sc.hasNext()) {
                        ID2 = sc.next();
                        Pass2 = sc.next();
                    }
                    if (ID1.equals(ID2)) {
                        menubar.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Password = " + Pass2, "Reset Password", JOptionPane.ERROR_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Not Matched !", "Sign in", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Not Matched !", "Sign in", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        l.LoginLabel[3].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                LogPanel[0].setVisible(false);
                LogPanel[1].setVisible(false);
                LogPanel[2].setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        l.LoginLabel[5].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                LogPanel[0].setVisible(false);
                LogPanel[1].setVisible(true);
                LogPanel[2].setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        cl.CreatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {

                    ID1 = cl.LogField.getText();
                    Pass1 = String.valueOf(cl.passField[0].getPassword());
                    Pass2 = String.valueOf(cl.passField[1].getPassword());

                    if (ID1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Username", "Create Account", JOptionPane.ERROR_MESSAGE);
                    } else if (Pass2.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Password", "Create Account", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (Pass1.equals(Pass2)) {
                            Formatter file = new Formatter(path + "/" + ID1 + ".bin");
                            file.format(ID1);
                            file.format(" " + Pass1);

                            file.close();
                            menubar.setVisible(true);
                            for (i = 0; i < 10; i++) {
                                if (i == 9) {
                                    panel[i].setVisible(true);
                                } else {
                                    panel[i].setVisible(false);
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Password Not Matched", "Create Account", JOptionPane.ERROR_MESSAGE);

                        }

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error found! Try again", "Create Account", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        l.LoginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    ID1 = l.LogField.getText();
                    Pass1 = String.valueOf(l.passField.getPassword());

                    File filein = new File(path + "/" + ID1 + ".bin");
                    Scanner sc = new Scanner(filein);
                    while (sc.hasNext()) {
                        ID2 = sc.next();
                        Pass2 = sc.next();
                    }
                    if (ID1.equals(ID2) && Pass1.equals(Pass2)) {
                        menubar.setVisible(true);
                        for (i = 0; i < 10; i++) {
                            if (i == 9) {
                                panel[i].setVisible(true);
                            } else {
                                panel[i].setVisible(false);
                            }

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Username & Password Not Matched !", "Sign in", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Username & Password Not Matched !", "Sign in", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        menubar = new JMenuBar();
        menubar.setBackground(Color.white);
        menubar.setVisible(false);
        this.setJMenuBar(menubar);

        menu = new JMenu[4];
        for (i = 0; i < 3; i++) {
            menu[i] = new JMenu("" + menuList[i]);
            menubar.add(menu[i]);
        }

        menuitem = new JMenuItem[11];
        for (i = 0; i < 10; i++) {
            menuitem[i] = new JMenuItem("" + menuS[i]);
            if (i < 2) {
                menu[0].add(menuitem[i]);
            } else if (i < 5) {
                menu[1].add(menuitem[i]);
            } else if (i >= 5) {
                menu[2].add(menuitem[i]);
            }
        }

        menuitem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 1) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 2) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                for (i = 0; i < 10; i++) {
                    if (i == 3) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 4) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 5) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 6) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });

        menuitem[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 8) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });

        menuitem[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 7) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    if (i == 9) {
                        panel[i].setVisible(true);
                    } else {
                        panel[i].setVisible(false);
                    }
                }
            }
        });
        menuitem[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (i = 0; i < 10; i++) {
                    panel[i].setVisible(false);
                }
                LogPanel[0].setVisible(true);
                panel[0].setVisible(true);
                LogPanel[2].setVisible(false);
                LogPanel[1].setVisible(false);
                menubar.setVisible(false);

            }
        });

        JLabel HomeImg = new JLabel();
        HomeImg.setIcon(ic.icon[1]);
        HomeImg.setBounds(100, 80, ic.icon[1].getIconWidth(), ic.icon[1].getIconHeight());
        panel[9].add(HomeImg);
        // Calculator Section
        final Calculator c = new Calculator();
        c.CalSec();

        CalPanel = new JPanel[4];
        for (i = 0; i < 3; i++) {
            CalPanel[i] = new JPanel();
            panel[1].add(CalPanel[i]);
        }

        OnOff.setBounds(20, 40, 55, 30);
        OnOff.setVisible(true);
        OnOff.setBackground(Color.white);
        OnOff.setToolTipText("Click here to On Calculator");

        OnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (OnOff.isSelected()) {
                    for (i = 0; i < 20; i++) {
                        c.b[i].setEnabled(false);
                    }
                    CalPanel[1].setVisible(false);
                    CalPanel[2].setVisible(true);
                    SciMode.setEnabled(false);
                    c.field.setText("");
                    OnOff.setText("Off");
                    SciMode.setText("Scientific (Off)");
                    OnOff.setToolTipText("Click here to On Calculator");
                } else {
                    for (i = 0; i < 20; i++) {
                        c.b[i].setEnabled(true);
                    }
                    SciMode.setEnabled(true);
                    OnOff.setToolTipText("Click here to Off Calculator");
                    OnOff.setText("On");
                }
            }
        });
        OnOff.setCursor(cursor);
        panel[1].add(OnOff);

        SciMode.setBounds(85, 40, 130, 30);
        SciMode.setVisible(true);
        SciMode.setBackground(Color.white);
        SciMode.setEnabled(false);
        SciMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (SciMode.isSelected()) {
                    CalPanel[1].setVisible(false);
                    CalPanel[2].setVisible(true);
                    SciMode.setText("Scientific (Off)");
                } else {
                    CalPanel[1].setVisible(true);
                    CalPanel[2].setVisible(false);
                    SciMode.setText("Scientific (On)");
                }
            }
        });
        SciMode.setCursor(cursor);
        panel[1].add(SciMode);

        panel[1].add(c.field);
        CalPanel[0].setBounds(5, 130, 225, 400);
        CalPanel[0].setVisible(true);
        for (i = 0; i < 20; i++) {
            CalPanel[0].add(c.b[i]);
        }

        // Sci Cal Panel 
        CalPanel[1].setBounds(250, 30, 225, 400);
        CalPanel[1].setVisible(false);

        for (i = 0; i < 21; i++) {
            CalPanel[1].add(c.b1[i]);
        }

        //Multiplication Table
        MTable ms = new MTable();
        ms.MTsec();

        panel[3].add(ms.label1);
        panel[3].add(ms.label2);
        panel[3].add(ms.mfield);
        panel[3].add(ms.clear);
        panel[3].add(ms.get);
        panel[3].add(ms.area);
        //Temperature Converter
        Temperature ts = new Temperature();
        ts.temoSec();

        panel[4].add(ts.topLabel);
        panel[4].add(ts.TempclearButton);
        for (i = 0; i < 9; i++) {
            if (i < 3) {
                panel[4].add(ts.TempField[i]);
                panel[4].add(ts.slider[i]);
            }
            panel[4].add(ts.label[i]);
        }

        // Currency Converter
        Currency cs = new Currency();
        cs.CurrSec();

        panel[5].add(cs.topLabel);
        panel[5].add(cs.lebel1);
        panel[5].add(cs.lebel2);
        panel[5].add(cs.lebel3);
        panel[5].add(cs.TextField);
        panel[5].add(cs.ConvertButton);
        panel[5].add(cs.clearButton);
        panel[5].add(cs.from);
        panel[5].add(cs.to);
        panel[5].add(cs.info);

        //BMI Calculator
        BMI bmi = new BMI();
        bmi.BMIsec();

        panel[2].add(bmi.information);
        for (i = 0; i < 5; i++) {
            if (i < 2) {
                panel[2].add(bmi.BMIField[i]);
                panel[2].add(bmi.BMIButton[i]);
            }
            panel[2].add(bmi.BMIlebel[i]);
        }

        // ChatBot Section
        final ChatBot cb = new ChatBot();
        cb.ChatSec();

        panel[7].add(cb.Bot);
        panel[7].add(cb.ChatField[0]);
        panel[7].add(cb.ChatField[1]);
        panel[7].add(cb.boticon);

        panel[7].add(cb.botbox);
        panel[7].add(cb.usericon);
        panel[7].add(cb.userBox);

        // About us Section
        AboutApp as = new AboutApp();
        as.AboutSec();

        panel[6].add(as.features);
        panel[6].add(as.features1);
        panel[6].add(as.Technology);
        panel[6].add(as.Technology1);
        panel[6].add(as.Editor);
        panel[6].add(as.Editor1);
        panel[6].add(as.Team);
        panel[6].add(as.Team1);
        panel[6].add(as.Team2);

        //Contact
        Contact cns = new Contact();
        cns.ContactSec();
        for (i = 0; i < 5; i++) {
            if (i < 2) {
                panel[8].add(cns.ContactField[i]);
            }
            panel[8].add(cns.ContactLabel[i]);
        }
        panel[8].add(cns.ContactSend);
        panel[8].add(cns.scroll);

        this.setVisible(true);
        this.validate();
    }

    public static void main(String[] args) {
        ProjectOOP frame = new ProjectOOP();
    }

}
