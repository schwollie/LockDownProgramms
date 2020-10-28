public class Main {

    public static void main(String[] args) {

        Window w = Window.getVirusWindow(1000, 1000);
        w.getCanvas().paintComponent(w.getGraphics());
        w.repaint();
    }

}
