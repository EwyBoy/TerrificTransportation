package com.modjam.terrifictransportation.KeyBindings;

import org.lwjgl.input.Keyboard;

public class KeyBindings {
    public static boolean shiftIsPressed() {

        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
    }
}
