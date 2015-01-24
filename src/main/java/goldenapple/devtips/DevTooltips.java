package main.java.goldenapple.devtips;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = DevTooltips.MOD_ID, name = DevTooltips.MOD_NAME, version = DevTooltips.VERSION)
public class DevTooltips {
    public static final String MOD_ID = "devtips";
    public static final String MOD_NAME = "DevTooltips";
    public static final String VERSION = "1.0";

    @Mod.Instance(MOD_ID)
    public static DevTooltips instance;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }
}
