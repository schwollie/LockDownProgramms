import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Window w = Window.getVirusWindow(1000, 1000);
        w.getCanvas().paintComponent(w.getGraphics());
        w.repaint();

        enableKeyListener();
    }

    private static void enableKeyListener(){
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyListener());
        Logger.getLogger("org.jnativehook").setLevel(Level.OFF);
    }

}
