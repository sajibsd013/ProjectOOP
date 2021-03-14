package projectoop;

import javax.swing.ImageIcon;

public class IconList {

    public ImageIcon icon[];

    public void il() {
        icon = new ImageIcon[20];

        for (int i = 0; i < 14; i++) {
            icon[i] = new ImageIcon(getClass().getResource("img/icon" + i + ".png"));
//             icon[i] = new ImageIcon("src/img/icon" + i + ".png");       
        }

    }

}
