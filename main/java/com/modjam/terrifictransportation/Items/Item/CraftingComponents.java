package com.modjam.terrifictransportation.Items.Item;

import com.modjam.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.terrifictransportation.Items.Technical.ItemInfo;
import com.modjam.terrifictransportation.Texture.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class CraftingComponents extends Item {

    public CraftingComponents() {
        super();
        setMaxStackSize(64);
        setCreativeTab(TTCreativeTabs.ClockworkItemTab);
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return ItemInfo.CraftingCompUnlocalized + stack.getItemDamage();
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        icons = new IIcon [ItemInfo.CraftingCompTexture.length];
        for (int i = 0; i < icons.length; i++)
        {
            icons [i] = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.CraftingCompTexture[i]);
        }
    }

    @Override
    public IIcon getIconFromDamage(int dmg) {
        return icons[dmg];
    }

    @Override
    public void getSubItems(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < ItemInfo.CraftingCompTexture.length; i++) {
            ItemStack stack = new ItemStack(id , 1, i);
            list.add(stack);
        }
    }
}
