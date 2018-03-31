package userui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MyDesktopPane extends JDesktopPane {

    private Image img;

    public MyDesktopPane() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/userui/hospital_icon.jpg"));
            img = icon.getImage();
        } catch (Exception ex) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } else {
            super.paintComponent(g);
        }
    }

}
