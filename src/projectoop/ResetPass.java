package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ResetPass {

    public JLabel ResetLabel[];
    public int i;
    public String ConS[] = {"Enter Your username or E-mail ", "Reset Password", "Login Now", "Create Account",""};
    public JTextField resetField;
    ;
    public JButton resetButton;
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public void RSec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        resetField = new JTextField();
        resetField.setBounds(150, 280, 200, 40);
        resetField.setFont(f.font[1]);
        resetField.setVisible(true);
        resetField.setHorizontalAlignment(JTextField.CENTER);
        resetField.setBackground(Color.decode("#f7f7f7"));

        resetButton = new JButton("GET PASSWORD");
        resetButton.setBounds(150, 340, 200, 40);
        resetButton.setFont(f.font[1]);
        resetButton.setVisible(true);
        resetButton.setCursor(cursor);
        resetButton.setBackground(Color.decode("#ffffff"));

        ResetLabel = new JLabel[5];

        for (i = 0; i < 5; i++) {

            ResetLabel[i] = new JLabel(ConS[i]);

        }

        ResetLabel[0].setBounds(150, 245, 360, 40);
        
        ResetLabel[1].setBounds(180, 200, 360, 40);
        ResetLabel[1].setFont(f.font[4]);
        
        ResetLabel[2].setBounds(160, 375, 70, 40);
        ResetLabel[2].setCursor(cursor);
        ResetLabel[2].setFont(f.font[0]);
        ResetLabel[2].setForeground(Color.decode("#4506E6"));
        
        ResetLabel[3].setBounds(250, 375, 100, 40);
        ResetLabel[3].setCursor(cursor);
        ResetLabel[3].setFont(f.font[0]);
        ResetLabel[3].setForeground(Color.decode("#4506E6"));
        
        ResetLabel[4].setIcon(ic.icon[9]);
        ResetLabel[4].setBounds(180, 30, ic.icon[9].getIconWidth(), ic.icon[9].getIconHeight());
    }

}
