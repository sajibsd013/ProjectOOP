package projectoop;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AboutApp {

    public JLabel features = new JLabel("Features :");
    public JTextArea features1 = new JTextArea("    i. Simple Calculator\n    ii. BMI Calculator\n    iii. Currency Converter\n    iv. Temperature Converter\n    v. Multiplication Table");
    public JLabel Technology = new JLabel("Technology :");
    public JLabel Technology1 = new JLabel("Object Oriented Programming Language (Java)");
    public JLabel Editor = new JLabel("Editor or IDE :");
    public JLabel Editor1 = new JLabel("NetBeans IDE 8.0.2");
    public JLabel Team = new JLabel("Design & Developed By-");
    public JLabel Team1 = new JLabel("Shubro Sutradhar & Sajib Vai ");
    public JLabel Team2 = new JLabel("BSc (Engg.) in CSE , NEUB");

    public void AboutSec() {

        FontList f = new FontList();
        f.fl();

        features.setBounds(25, 0, 300, 50);
        features.setFont(f.font[2]);
        
        features1.setBounds(20, 45, 480, 100);
        features1.setEditable(false);
        features1.setBackground(Color.decode("#EEEEEE"));
        features1.setFont(f.font[8]);



        Technology.setBounds(25, 115, 130, 100);
        Technology.setFont(f.font[2]);

        Technology1.setBounds(130, 115, 500, 100);
        Technology1.setFont(f.font[8]);

        Editor.setBounds(25, 145, 370, 100);
        Editor.setFont(f.font[2]);

        Editor1.setBounds(160, 145, 500, 100);
        Editor1.setFont(f.font[8]);

        Team.setBounds(120, 215, 370, 100);
        Team.setFont(f.font[8]);

        Team1.setBounds(175, 240, 500, 100);
        Team1.setFont(f.font[1]);

        Team2.setBounds(145, 260, 500, 100);
        Team2.setFont(f.font[8]);

       
    }

}
