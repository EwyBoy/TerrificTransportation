package com.modjam.terrifictransportation.CreativeTabs;

import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import com.modjam.terrifictransportation.Items.Technical.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TTCreativeTabs {

    public static void init() {
        addCreativeTabs();
    }
    public static void addCreativeTabs() {}

        public static CreativeTabs ClockworkBlockTab = new CreativeTabs ("Clockwork Block") {
            public ItemStack getIconItemStack() {
                return new ItemStack(Blocks.Conveyor);
            }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
            public static CreativeTabs ClockworkItemTab = new CreativeTabs ("Clockwork Block") {
                public ItemStack getIconItemStack() {
                    return new ItemStack(Items.Wrench);
                }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
}
