package main.java.goldenapple.devtips;

import cpw.mods.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

public class DevTooltipsGuiFactory implements IModGuiFactory{
    @Override
    public void initialize(Minecraft minecraftInstance) {
        //unused
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() { //the only method we care about
        return DevTooltipsConfigGui.class;
    }

    @Override
    public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null; //unused
    }

    @Override
    public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
        return null; //unused
    }
}
