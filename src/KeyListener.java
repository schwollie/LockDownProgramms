import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;

public class KeyListener implements NativeKeyListener {

    private Robot robot;
    public KeyListener(){
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        String pressedKey = NativeKeyEvent.getKeyText(keyCode);
        System.out.println("Key Released: " + pressedKey);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        if ((e.getModifiers() & NativeInputEvent.CTRL_R_MASK) != 0 && e.getKeyCode() == NativeKeyEvent.VC_F) {
            System.exit(0);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }
}

