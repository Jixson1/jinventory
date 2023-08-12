package net.jixson.jinventory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class JInventoryClient implements ClientModInitializer {

    private static KeyBinding toggleSlotLock;
    @Override
    public void onInitializeClient() {
        toggleSlotLock = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Toggle Slot Lock",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_GRAVE_ACCENT,
            "JInventory"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleSlotLock.wasPressed()) {
                client.player.sendMessage(Text.literal("Key pressed"), false);

            }
        });
    }
}
