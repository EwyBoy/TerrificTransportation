package com.modjam.terrifictransportation.CreativeTabs;

import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import com.modjam.terrifictransportation.Items.Technical.Items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TTCreativeTabs {

    public static void init() {
        addCreativeTabs();
        LanguageRegistry.instance().addStringLocalization("itemGroup.TerrificTransportation_Blocks", "en_US", "TerrificTransportation Blocks");
        LanguageRegistry.instance().addStringLocalization("itemGroup.TerrificTransportation_Items", "en_US", "TerrificTransportation Items");
        
    }
    public static void addCreativeTabs() {}

        public static CreativeTabs ClockworkBlockTab = new CreativeTabs ("TerrificTransportation Blocks") {
            public ItemStack getIconItemStack() {
                return new ItemStack(Blocks.Conveyor);
            }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
            public static CreativeTabs ClockworkItemTab = new CreativeTabs ("TerrificTransportation Items") {
                public ItemStack getIconItemStack() {
                    return new ItemStack(Items.Wrench);
                }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
}
