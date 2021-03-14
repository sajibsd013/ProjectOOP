package projectoop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChatBot {

    // ChatBot Section
    public JLabel Bot = new JLabel();
    public JLabel boticon = new JLabel();
    public JTextField ChatField[];
    public JLabel botbox = new JLabel();
    public JLabel usericon = new JLabel();
    public JLabel userBox = new JLabel();

    public void ChatSec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();
        ChatField = new JTextField[2];

        for (int i = 0; i < 2; i++) {
            ChatField[i] = new JTextField();
            ChatField[i].setHorizontalAlignment(JTextField.CENTER);
            ChatField[i].setFont(f.font[0]);
            ChatField[i].setVisible(true);
        }

        ChatField[0].setText("Hi, what can I do for you today?");
        ChatField[0].setBounds(128, 244, 220, 62);
        ChatField[1].setBounds(152, 332, 212, 66);
        ChatField[1].setBackground(Color.decode("#EEEEEE"));

        // Chat Bot ActionListener
        ChatField[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String str = ChatField[1].getText();

                ChatField[1].setText("");
                if (str.equalsIgnoreCase("Hi")) {
                    ChatField[0].setText("Hello Sir! ");
                } else if (str.equalsIgnoreCase("hello")) {
                    ChatField[0].setText("Hi Sir!");

                } else if (str.equalsIgnoreCase("how are you")) {
                    ChatField[0].setText("I'm fine, & you ?");

                } else if (str.equalsIgnoreCase("Fine")) {
                    ChatField[0].setText("That's great! ");

                } else if (str.equalsIgnoreCase("well")) {
                    ChatField[0].setText("That's great! ");

                } else if (str.equalsIgnoreCase("I am Fine")) {
                    ChatField[0].setText("That's great!");

                } else if (str.equalsIgnoreCase("I am also Fine")) {
                    ChatField[0].setText("That's great! ");

                } else {
                    ChatField[0].setText("Sorry, I don't understood.");
                }
            }

        });

        ChatField[0].setEditable(false);
        ChatField[1].setEditable(true);

        Bot.setIcon(ic.icon[7]);
        Bot.setBounds(150, 20, ic.icon[7].getIconWidth(), ic.icon[7].getIconHeight());

        boticon.setIcon(ic.icon[6]);
        boticon.setBounds(10, 170, ic.icon[6].getIconWidth(), ic.icon[6].getIconHeight());
        
        botbox.setIcon(ic.icon[3]);
        botbox.setBounds(90, 240, ic.icon[3].getIconWidth(), ic.icon[3].getIconHeight());

        usericon.setIcon(ic.icon[5]);
        usericon.setBounds(380, 260, ic.icon[5].getIconWidth(), ic.icon[5].getIconHeight());

        userBox.setIcon(ic.icon[4]);
        userBox.setBounds(130, 330, ic.icon[4].getIconWidth(), ic.icon[4].getIconHeight());

    }

}
