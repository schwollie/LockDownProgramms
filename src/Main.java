import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        Window w = Window.getVirusWindow(1000, 1000);
        w.getCanvas().paintComponent(w.getGraphics());
        w.repaint();

        enableKeyListener();

        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("jars/test.jar");
        int exitVal = proc.exitValue();
        System.out.println("Process exitValue: " + exitVal);
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
