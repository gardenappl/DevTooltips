package goldenapple.devtips;

import org.lwjgl.input.Keyboard;

public class MiscUtil {
    public static boolean isCtrlPressed(){
        return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
    }
}
