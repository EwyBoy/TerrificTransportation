package com.modjam.terrifictransportation.Items.Item;

import com.modjam.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.terrifictransportation.Items.Technical.ItemInfo;
import com.modjam.terrifictransportation.KeyBindings.KeyBindings;
import com.modjam.terrifictransportation.Texture.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class Wrench extends Item {

    public Wrench() {
        super();
        setMaxStackSize(1);
        setCreativeTab(TTCreativeTabs.ClockworkItemTab);
    }

    private String WrenchType = "Deactivated";
    private int WrenchTypeID = 0;

    private int ModeDeactivated = 0;
    private int ModeRotate = 1;
    private int ModeInteraction = 2;

    public String getWrenchType() {
        return WrenchType;
    }

    public int getWrenchTypeID() {
        return WrenchTypeID;
    }

    public void setWrenchType(String type) {
        WrenchType = type;
    }

    private void setWrenchTypeID(int type) {
        WrenchTypeID = type;
    }

    private boolean isActivated(int dmg) {
        return dmg >= 2;
    }
    private boolean isDeactivated(int dmg) {
        return dmg <= 2;
    }

    private void playSoundEffect(World world, EntityPlayer player) {

        world.playSound(player.posX, player.posY, player.posZ, "tile.piston.in", 0.5F, 0.4F + 0.8F, false);
    }

    public void changeWrench(World world, EntityPlayer player) {
        if(getWrenchTypeID() == 0) {
            setWrenchType("Rotation Mode");
            setWrenchTypeID(ModeRotate);
            playSoundEffect(world, player);
        } else if (getWrenchTypeID() == 1) {
            setWrenchType("Interaction Mode");
            setWrenchTypeID(ModeInteraction);
            playSoundEffect(world, player);
        }else if (getWrenchTypeID() == 2) {
            setWrenchType("Deactivated");
            setWrenchTypeID(ModeDeactivated);
            playSoundEffect(world, player);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {


        if (getWrenchTypeID() == ModeInteraction) {

        }

        if (player.isSneaking() == true) {
            changeWrench(world, player);
        }
       
        return item;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {

        info.add("Wrench Mode: " + getWrenchType());

        if (KeyBindings.shiftIsPressed() == true) {

            if (getWrenchTypeID() == ModeRotate) {
                info.add("This mode is for rotating tiles");
            }

            if (getWrenchTypeID() == ModeInteraction) {
                info.add("This mode is for interacting with stuff");
            }

            if (getWrenchTypeID() == ModeDeactivated) {
                info.add("Wrench is now deactivated");
            }
        }

    }

    @SideOnly(Side.CLIENT)
    private IIcon WrenchActivated01;
    private IIcon WrenchActivated02;
    private IIcon WrenchDeactivated;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        WrenchActivated01 = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.WrenchActivatedTexture01);
        WrenchActivated02 = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.WrenchActivatedTexture02);
        WrenchDeactivated = register.registerIcon(TextureHandler.texturePath + ":" + ItemInfo.WrenchDeactivatedTexture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int idk) {

        if(getWrenchTypeID() == ModeRotate) {
            return WrenchActivated01;
        } else if (getWrenchTypeID() == ModeInteraction) {
            return WrenchActivated02;
        }
        return WrenchDeactivated;
    }
}