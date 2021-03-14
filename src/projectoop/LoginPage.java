package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class LoginPage {

    public JLabel LoginLabel[];
    public int i, pos = 220;
    public String pass, ConS[] = {"Username or E-mail  ", "Password", "Member Login", "Forgot Password?", "Not a member ?", "Create Account", "", ""};
    public JTextField LogField, SpassField;
    public JPasswordField passField;
    public JButton LoginButton;
    public JToggleButton showPassButton = new JToggleButton("", true);
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public void LogSec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        LogField = new JTextField();
        LogField.setBounds(150, 245, 200, 35);
        LogField.setFont(f.font[1]);
        LogField.setVisible(true);
        LogField.setHorizontalAlignment(JTextField.CENTER);
        LogField.setBackground(Color.decode("#f7f7f7"));

        passField = new JPasswordField();
        passField.setBounds(150, 300, 200, 35);
        passField.setFont(f.font[1]);
        passField.setVisible(true);
        passField.setHorizontalAlignment(JPasswordField.CENTER);
        passField.setBackground(Color.decode("#f7f7f7"));
        passField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                showPassButton.setVisible(true);
            }
        });

        SpassField = new JTextField();
        SpassField.setBounds(150, 300, 200, 35);
        SpassField.setFont(f.font[1]);
        SpassField.setVisible(false);
        SpassField.setHorizontalAlignment(JPasswordField.CENTER);
        SpassField.setBackground(Color.decode("#f7f7f7"));

        LoginButton = new JButton("Login");
        LoginButton.setBounds(150, 365, 200, 40);
        LoginButton.setFont(f.font[3]);
        LoginButton.setVisible(true);
        LoginButton.setCursor(cursor);
        LoginButton.setBackground(Color.decode("#ffffff"));

        LoginLabel = new JLabel[10];

        for (i = 0; i < 7; i++) {

            LoginLabel[i] = new JLabel(ConS[i]);
            LoginLabel[i].setBounds(150, pos, 300, 30);
            LoginLabel[i].setVisible(true);
            pos += 55;

        }
        LoginLabel[2].setBounds(180, 180, 360, 40);
        LoginLabel[2].setFont(f.font[4]);

        LoginLabel[3].setBounds(150, 325, 110, 40);
        LoginLabel[3].setCursor(cursor);
        LoginLabel[3].setForeground(Color.decode("#4506E6"));

        LoginLabel[4].setBounds(150, 395, 100, 40);

        LoginLabel[5].setBounds(245, 395, 100, 40);
        LoginLabel[5].setFont(f.font[0]);
        LoginLabel[5].setCursor(cursor);
        LoginLabel[5].setForeground(Color.decode("#4506E6"));

        LoginLabel[6].setIcon(ic.icon[8]);
        LoginLabel[6].setBounds(180, 15, ic.icon[8].getIconWidth(), ic.icon[8].getIconHeight());

        showPassButton.setCursor(cursor);
        showPassButton.setIcon(ic.icon[13]);
        showPassButton.setVisible(false);
        showPassButton.setBackground(Color.decode("#f7f7f7"));
        showPassButton.setBounds(355, 308, ic.icon[13].getIconWidth(), ic.icon[13].getIconHeight());
        showPassButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (showPassButton.isSelected()) {
                    SpassField.setVisible(false);
                    passField.setVisible(true);
                    showPassButton.setIcon(ic.icon[13]);

                } else {

                    pass = String.valueOf(passField.getPassword());
                    SpassField.setText(pass);
                    SpassField.setVisible(true);
                    passField.setVisible(false);
                    showPassButton.setIcon(ic.icon[12]);

                }
            }
        });

        SpassField.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                SpassField.setVisible(false);
                passField.setVisible(true);
                showPassButton.setIcon(ic.icon[13]);
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
