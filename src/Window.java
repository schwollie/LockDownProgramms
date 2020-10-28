import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Canvas canvas;

    public Window(int width, int height) {
        super();
        this.setSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.setVisible(true);
        this.setResizable(false);

        canvas = new Canvas();
        this.add(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public static Window getVirusWindow(int width, int height) {
        return new Window(width, height);
    }

}
