import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private BufferedImage img;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        g.setColor(new Color(0,0,0));
        g.fillRect(0, 0, 200, 200);
    }
}
