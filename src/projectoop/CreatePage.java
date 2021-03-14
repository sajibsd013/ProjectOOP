package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class CreatePage {

    public JLabel CreateLabel[];
    public int i;
    public String c1, c2, path, ID1, ID2, pass, ConS[] = {"Username or E-mail  ", "Password", "Re-type Password", "Create Account", " ", "Have a account?", "Login now", ""};
    public JTextField LogField, SpassField[];
    public JPasswordField passField[];
    public JButton CreatButton;
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    public JToggleButton showPassButton[];

    public void CreateSec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        File CreteFile = new File("Login");
        CreteFile.mkdir();
        path = CreteFile.getAbsolutePath();

        showPassButton = new JToggleButton[2];
        SpassField = new JTextField[2];

        LogField = new JTextField();
        LogField.setBounds(150, 215, 200, 35);
        LogField.setFont(f.font[1]);
        LogField.setVisible(true);
        LogField.setHorizontalAlignment(JTextField.CENTER);
        LogField.setBackground(Color.decode("#f7f7f7"));

        passField = new JPasswordField[2];
        for (i = 0; i < 2; i++) {
            passField[i] = new JPasswordField();
            passField[i].setFont(f.font[1]);
            passField[i].setVisible(true);
            passField[i].setHorizontalAlignment(JPasswordField.CENTER);
            passField[i].setBackground(Color.decode("#f7f7f7"));

            SpassField[i] = new JTextField();
            SpassField[i].setFont(f.font[2]);
            SpassField[i].setVisible(false);
            SpassField[i].setHorizontalAlignment(JPasswordField.CENTER);
            SpassField[i].setBackground(Color.decode("#f7f7f7"));

            showPassButton[i] = new JToggleButton("", true);
            showPassButton[i].setCursor(cursor);
            showPassButton[i].setVisible(false);
            showPassButton[i].setIcon(ic.icon[13]);
            showPassButton[i].setBackground(Color.decode("#f7f7f7"));

        }
        passField[0].setBounds(150, 270, 200, 35);
        passField[0].addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                showPassButton[0].setVisible(true);

            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        });
        SpassField[0].setBounds(150, 270, 200, 35);
        passField[1].setBounds(150, 325, 200, 35);
        SpassField[1].setBounds(150, 325, 200, 35);
        passField[1].addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                showPassButton[1].setVisible(true);

            }

            @Override
            public void keyReleased(KeyEvent ke) {

                c1 = String.valueOf(passField[0].getPassword());
                c2 = String.valueOf(passField[1].getPassword());

                if (c1.equals(c2)) {
                    passField[1].setBackground(Color.green);
                } else {
                    passField[1].setBackground(Color.pink);

                }
            }
        });

        CreatButton = new JButton("Create Account");
        CreatButton.setBounds(150, 370, 200, 40);
        CreatButton.setFont(f.font[3]);
        CreatButton.setVisible(true);
        CreatButton.setCursor(cursor);
        CreatButton.setBackground(Color.decode("#ffffff"));

        CreateLabel = new JLabel[10];

        for (i = 0; i < 8; i++) {

            CreateLabel[i] = new JLabel(ConS[i]);
            CreateLabel[i].setVisible(true);

        }
        CreateLabel[0].setBounds(150, 190, 200, 30);
        CreateLabel[1].setBounds(150, 245, 200, 30);
        CreateLabel[2].setBounds(150, 300, 200, 30);

        CreateLabel[3].setBounds(180, 150, 360, 40);
        CreateLabel[3].setFont(f.font[4]);

        CreateLabel[4].setBounds(360, 325, 200, 35);

        CreateLabel[5].setBounds(150, 400, 100, 40);

        CreateLabel[6].setBounds(255, 400, 70, 40);
        CreateLabel[6].setCursor(cursor);
        CreateLabel[6].setFont(f.font[0]);
        CreateLabel[6].setForeground(Color.decode("#4506E6"));

        CreateLabel[7].setIcon(ic.icon[10]);
        CreateLabel[7].setBounds(180, 10, ic.icon[10].getIconWidth(), ic.icon[10].getIconHeight());

        showPassButton[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (showPassButton[0].isSelected()) {
                    SpassField[0].setVisible(false);
                    passField[0].setVisible(true);
                    showPassButton[0].setIcon(ic.icon[13]);

                } else {

                    pass = String.valueOf(passField[0].getPassword());
                    SpassField[0].setText(pass);
                    SpassField[0].setVisible(true);
                    passField[0].setVisible(false);
                    showPassButton[0].setIcon(ic.icon[12]);

                }
            }
        });
        showPassButton[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (showPassButton[1].isSelected()) {
                    SpassField[1].setVisible(false);
                    passField[1].setVisible(true);
                    showPassButton[1].setIcon(ic.icon[13]);

                } else {

                    pass = String.valueOf(passField[1].getPassword());
                    SpassField[1].setText(pass);
                    SpassField[1].setVisible(true);
                    passField[1].setVisible(false);
                    showPassButton[1].setIcon(ic.icon[12]);

                }
            }
        });

        showPassButton[0].setBounds(360, 275, ic.icon[12].getIconWidth(), ic.icon[12].getIconHeight());
        showPassButton[1].setBounds(360, 330, ic.icon[12].getIconWidth(), ic.icon[12].getIconHeight());

        SpassField[0].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                SpassField[0].setVisible(false);
                passField[0].setVisible(true);
                showPassButton[0].setIcon(ic.icon[13]);
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

        SpassField[1].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                SpassField[1].setVisible(false);
                passField[1].setVisible(true);
                showPassButton[1].setIcon(ic.icon[13]);
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

    }
}
