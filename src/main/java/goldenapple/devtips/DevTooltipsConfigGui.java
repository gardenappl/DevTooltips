package main.java.goldenapple.devtips;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class DevTooltipsConfigGui extends GuiConfig {
    @SuppressWarnings({"unchecked"})
    public DevTooltipsConfigGui(GuiScreen parentScreen){
        super(parentScreen,
                new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                DevTooltips.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}
