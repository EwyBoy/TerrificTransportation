package com.modjam.terrifictransportation.Items.Technical;

import com.modjam.terrifictransportation.Items.Item.CraftingComponents;
import com.modjam.terrifictransportation.Items.Item.Modules;
import com.modjam.terrifictransportation.Items.Item.Wrench;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items {

    public static Item Wrench;
    public static Item Modules;
    public static Item CraftingComp;

    public static void init() {
        registerItems();
        addItems();
    }

    public static void registerItems() {
        Wrench = new Wrench().setUnlocalizedName(ItemInfo.WrenchUnlocalized);
        Modules = new com.modjam.terrifictransportation.Items.Item.Modules().setUnlocalizedName(ItemInfo.ModulesUnlocalized);
        CraftingComp = new CraftingComponents().setUnlocalizedName(ItemInfo.CraftingCompUnlocalized);
    }

    public static void addItems() {
        GameRegistry.registerItem(Wrench, ItemInfo.WrenchUnlocalized);
        GameRegistry.registerItem(Modules, ItemInfo.ModulesUnlocalized);
        GameRegistry.registerItem(CraftingComp, ItemInfo.CraftingCompUnlocalized);
    }
}
