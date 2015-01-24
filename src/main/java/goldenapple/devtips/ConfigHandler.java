package goldenapple.devtips;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static boolean requiresCtrl;
    public static boolean requiresF3plusH;
    public static boolean showGameRegistryNames;
    public static boolean showFluidRegistryNames;
    public static boolean showClassNames;
    public static boolean showOreDictNames;

    public static void init(File configFile){
        if(config == null) {
            config = new Configuration(configFile);
        }
        getValues();
    }

    private static void getValues(){
        requiresCtrl = config.getBoolean("requiresCtrl", Configuration.CATEGORY_GENERAL, true, "If set to false, tooltips will be shown without pressing Ctrl.");
        requiresF3plusH = config.getBoolean("requiresF3+H", Configuration.CATEGORY_GENERAL, true, "If set to false, tooltips will be shown without going into Advanced Info mode (F3 + H).");
        showGameRegistryNames = config.getBoolean("showGameRegistryNames", Configuration.CATEGORY_GENERAL, true, "If set to true, GameRegistry names of items and blocks will be shown in the tooltip.");
        showFluidRegistryNames = config.getBoolean("showFluidRegistryNames", Configuration.CATEGORY_GENERAL, true, "If set to true, FluidRegistry names of fluids and fluid containers will be shown in the tooltip.");
        showClassNames = config.getBoolean("showClassNames", Configuration.CATEGORY_GENERAL, true, "If set to true, item and block class names of items and blocks will be shown in the tooltip. Only useful for programmers.");
        showOreDictNames = config.getBoolean("showOreDictNames", Configuration.CATEGORY_GENERAL, true, "If set to true, OreDictionary entries of items and blocks will be shown in the tooltip.");

        if(config.hasChanged()){
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equals(DevTooltips.MOD_ID)){
            getValues();
        }
    }
}
