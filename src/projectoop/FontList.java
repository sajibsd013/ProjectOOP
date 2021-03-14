package projectoop;

import java.awt.Font;

public class FontList {

    public Font font[];

    public void fl() {
        font = new Font[12];

        font[0] = new Font("Times New Roman", Font.BOLD, 14);
        font[1] = new Font("Times New Roman", Font.BOLD, 16);
        font[2] = new Font("Times New Roman", Font.BOLD, 18);
        font[3] = new Font("Times New Roman", Font.BOLD, 20);
        font[4] = new Font("Times New Roman", Font.BOLD, 22);
        font[5] = new Font("Times New Roman", Font.ITALIC, 20);
        font[6] = new Font("Times New Roman", Font.BOLD, 24);
        font[7] = new Font("Times New Roman", Font.TRUETYPE_FONT, 28);
        font[8] = new Font("Times New Roman", Font.ITALIC, 15);

    }

}
