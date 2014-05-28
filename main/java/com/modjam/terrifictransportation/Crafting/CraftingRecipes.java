package com.modjam.terrifictransportation.Crafting;

import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingRecipes {

    public static void init() {
        registerCrafting();
    }

    public static void registerCrafting() {

        Item craftingComp = com.modjam.terrifictransportation.Items.Technical.Items.CraftingComp;
        Item wrench = com.modjam.terrifictransportation.Items.Technical.Items.Wrench;

        GameRegistry.addRecipe(new ItemStack(Blocks.Conveyor, 4),
                "IMI", "XOX",
                'I', Items.iron_ingot,
                'X', new ItemStack(craftingComp, 1, 0),
                'M', new ItemStack(craftingComp, 1, 3),
                'O', new ItemStack(craftingComp, 1, 2));

        //Gear
        GameRegistry.addRecipe(new ItemStack(craftingComp, 2, 0),
                " X ","X X", " X ", 'X', Items.iron_ingot);

        //Roller
        GameRegistry.addRecipe(new ItemStack(craftingComp, 1, 1),
                "X","X", 'X', Items.iron_ingot);

        //RollerStrip
        GameRegistry.addRecipe(new ItemStack(craftingComp, 1, 2),
                "XXX", 'X', new ItemStack(craftingComp, 1, 1));

        //Belt
        GameRegistry.addRecipe(new ItemStack(craftingComp, 1, 3),
                "XX","XX", 'X', Items.gold_ingot);

        //Handel
        GameRegistry.addRecipe(new ItemStack(craftingComp, 1, 6),
                "X","G","X", 'G', Items.gold_ingot, 'X', Items.iron_ingot);

        //Core
        GameRegistry.addRecipe(new ItemStack(craftingComp, 1, 5),
                "XGX", 'G', net.minecraft.init.Blocks.lapis_block, 'X', Items.iron_ingot);

        //Head
        GameRegistry.addRecipe(new ItemStack(craftingComp, 1, 4),
                "X X","X X"," X ",'X', net.minecraft.init.Blocks.lapis_block, 'X', Items.iron_ingot);

        //Wrench
        GameRegistry.addRecipe(new ItemStack(wrench, 1),
                "X","Y","Z",

                'X', new ItemStack(craftingComp, 1, 4),
                'Y', new ItemStack(craftingComp, 1, 5),
                'Z', new ItemStack(craftingComp, 1, 6));

        //Wrench
        GameRegistry.addRecipe(new ItemStack(wrench, 1),
                "  X"," Y ","Z  ",

                'X', new ItemStack(craftingComp, 1, 4),
                'Y', new ItemStack(craftingComp, 1, 5),
                'Z', new ItemStack(craftingComp, 1, 6));
    }
}
