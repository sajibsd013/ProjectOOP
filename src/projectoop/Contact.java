package projectoop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Contact {

    public String Name, mail, msg;
    public JLabel ContactLabel[];
    public int i, pos = 135;
    public String path, ConS[] = {"CONTACT US", "Full Name:", "E-mail:", "Message:", ""};
    public JTextField ContactField[];
    public JTextArea ContactArea;
    public JScrollPane scroll;
    public JButton ContactSend;
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public void ContactSec() {
        final IconList ic = new IconList();
        ic.il();
        final FontList f = new FontList();
        f.fl();

        File file = new File("Contact");
        file.mkdir();
        path = file.getAbsolutePath();

        ContactLabel = new JLabel[6];
        ContactField = new JTextField[5];
        for (i = 0; i < 5; i++) {
            if (i < 2) {
                ContactField[i] = new JTextField();
                ContactField[i].setVisible(true);
                ContactField[i].setFont(f.font[1]);
            }

            ContactLabel[i] = new JLabel(ConS[i]);
            ContactLabel[i].setBounds(125, pos, 300, 30);
            ContactLabel[i].setVisible(true);
            pos += 50;

        }
        ContactField[0].setBounds(125, 210, 250, 30);
        ContactField[1].setBounds(125, 260, 250, 30);

        ContactLabel[0].setBounds(170, 145, 300, 50);
        ContactLabel[0].setFont(f.font[4]);

        ContactLabel[4].setIcon(ic.icon[11]);
        ContactLabel[4].setBounds(180, 5, ic.icon[11].getIconWidth(), ic.icon[11].getIconHeight());

        ContactArea = new JTextArea();
        ContactArea.setFont(f.font[1]);
        ContactArea.setVisible(true);
        ContactArea.setLineWrap(true);
        ContactArea.setWrapStyleWord(true);
        ContactArea.setBackground(Color.decode("#f7f7f7"));

        scroll = new JScrollPane(ContactArea);
        scroll.setBounds(125, 310, 250, 60);

        ContactSend = new JButton("SEND");
        ContactSend.setBounds(170, 380, 160, 40);
        ContactSend.setFont(f.font[1]);
        ContactSend.setVisible(true);
        ContactSend.setCursor(cursor);
        ContactSend.setBackground(Color.white);
        ContactSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Name = ContactField[0].getText();
                    mail = ContactField[1].getText();
                    msg = ContactArea.getText();

                    if (Name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Your Name!", "Contact Form", JOptionPane.ERROR_MESSAGE);
                    } else if (mail.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Your E-mail", "Contact Form", JOptionPane.ERROR_MESSAGE);
                    } else if (msg.isEmpty()) {
                        JOptionPane.showMessageDialog(null, msg + "Enter Your Message", "Contact Form", JOptionPane.ERROR_MESSAGE);
                    } else {

                        Formatter file = new Formatter(path + "/" + Name + ".txt");
                        file.format("Name : " + Name + "\n\n");
                        file.format("E-mail : " + mail + "\n\n");
                        file.format("Message : \n" + msg + "\n\n");
                        file.close();
                        ContactField[0].setText("");
                        ContactField[1].setText("");
                        ContactArea.setText("");
                        JOptionPane.showMessageDialog(null, "MESSAGE DELIVERD!", "Contact Form", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "MESSAGE NOT DELIVERD!", "Contact Form", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

    }
}
