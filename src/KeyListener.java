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
        String pressedKey = NativeKeyEvent.getKeyText(e.getKeyCode());
        System.out.println("Key Released: " + pressedKey);
        /*robot.keyPress(e.getRawCode());
        robot.keyRelease(e.getRawCode());*/
        if ((e.getModifiers() & NativeInputEvent.CTRL_R_MASK) != 0 && e.getKeyCode() == NativeKeyEvent.VC_F) {
            System.exit(0);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }
}

