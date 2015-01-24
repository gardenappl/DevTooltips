package goldenapple.devtips;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class TooltipHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTooltip(ItemTooltipEvent event){
        if((ConfigHandler.requiresF3plusH && event.showAdvancedItemTooltips) || !ConfigHandler.requiresF3plusH){
            if((ConfigHandler.requiresCtrl && MiscUtil.isCtrlPressed()) || !ConfigHandler.requiresCtrl){
                event.toolTip.add(EnumChatFormatting.GOLD.toString() + "Unlocalized name: " + EnumChatFormatting.GRAY.toString() + event.itemStack.getItem().getUnlocalizedName());

                //GameRegistry stuff
                if(ConfigHandler.showGameRegistryNames) {
                    if (GameRegistry.findUniqueIdentifierFor(event.itemStack.getItem()) != null) {
                        event.toolTip.add(EnumChatFormatting.DARK_AQUA.toString() + "GameRegistry name: " + EnumChatFormatting.GRAY.toString() + GameRegistry.findUniqueIdentifierFor(event.itemStack.getItem()).name);
                        event.toolTip.add(EnumChatFormatting.DARK_AQUA.toString() + "Mod ID: " + EnumChatFormatting.GRAY.toString() + GameRegistry.findUniqueIdentifierFor(event.itemStack.getItem()).modId);
                    } else {
                        event.toolTip.add(EnumChatFormatting.RED.toString() + "Uh oh. It looks like this item has not");
                        event.toolTip.add(EnumChatFormatting.RED.toString() + "been registered. This is a bug!");
                    }
                }

                //FluidRegistry stuff
                if(ConfigHandler.showFluidRegistryNames) {
                    if (FluidContainerRegistry.isFilledContainer(event.itemStack)) {
                        event.toolTip.add(EnumChatFormatting.AQUA.toString() + "FluidRegistry name: " + EnumChatFormatting.GRAY.toString() + FluidRegistry.getFluidName(FluidContainerRegistry.getFluidForFilledItem(event.itemStack)));
                    } else if (event.itemStack.getItem() instanceof ItemBlock) {
                        if (FluidRegistry.lookupFluidForBlock(Block.getBlockFromItem(event.itemStack.getItem())) != null)
                            event.toolTip.add(EnumChatFormatting.AQUA.toString() + "FluidRegistry name: " + EnumChatFormatting.GRAY.toString() + FluidRegistry.lookupFluidForBlock(Block.getBlockFromItem(event.itemStack.getItem())).getName());
                    }
                }

                //Classes
                if(ConfigHandler.showClassNames) {
                    event.toolTip.add(EnumChatFormatting.DARK_PURPLE.toString() + "Item class name: " + EnumChatFormatting.GRAY.toString() + event.itemStack.getItem().getClass().getCanonicalName());
                    if (event.itemStack.getItem() instanceof ItemBlock) {
                        event.toolTip.add(EnumChatFormatting.DARK_PURPLE.toString() + "Block class name: " + EnumChatFormatting.GRAY.toString() + Block.getBlockFromItem(event.itemStack.getItem()).getClass().getCanonicalName());
                    }
                }

                //OreDictionary stuff
                if(ConfigHandler.showOreDictNames) {
                    if (OreDictionary.getOreIDs(event.itemStack).length != 0) {
                        event.toolTip.add(EnumChatFormatting.DARK_GREEN.toString() + "OreDictionary names:");
                        for (int id : OreDictionary.getOreIDs(event.itemStack)) {
                            event.toolTip.add("  " + OreDictionary.getOreName(id));
                        }
                    }
                }
            }else{
                event.toolTip.add(EnumChatFormatting.DARK_GRAY.toString() + event.itemStack.getItem().getUnlocalizedName());
                event.toolTip.add("Hold Ctrl for more info");
            }
        }
    }
}
