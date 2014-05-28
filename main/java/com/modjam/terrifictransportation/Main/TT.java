package com.modjam.terrifictransportation.Main;


import net.minecraft.util.ResourceLocation;

import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import com.modjam.terrifictransportation.Crafting.CraftingRecipes;
import com.modjam.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.terrifictransportation.Info.ModInfo;
import com.modjam.terrifictransportation.Items.Technical.Items;
import com.modjam.terrifictransportation.KeyBindings.KeyBindings;
import com.modjam.terrifictransportation.Network.Proxies.CommonProxy;
import com.modjam.terrifictransportation.Network.Packets.PacketPipeline;
import com.modjam.terrifictransportation.Texture.TextureHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ModID, name = ModInfo.ModName, version = ModInfo.ModVersion)

public class TT
{
    @Mod.Instance(ModInfo.ModID)
    public static TT instance;

    @SidedProxy(modId = ModInfo.ModID, clientSide = "com.modjam.terrifictransportation.Network.Proxies.ClientProxy", serverSide = "com.modjam.terrifictransportation.Network.Proxies.CommonProxy")
    public static CommonProxy proxy;
    public static final PacketPipeline packetPipeline = new PacketPipeline();
    
    @Mod.EventHandler
    public void PreInit (FMLPreInitializationEvent event)
    {
        Blocks.init();
        Items.init();
        TTCreativeTabs.init();
        proxy.initRenders();
        KeyBindings.shiftIsPressed();
        CraftingRecipes.init();
        System.out.print(new ResourceLocation(TextureHandler.texturePath + ":" + "Conveyor.tcn").getResourceDomain());
    }

    @Mod.EventHandler
    public void load (FMLInitializationEvent event)
    {
    	  packetPipeline.initialise();
    }

    @Mod.EventHandler
    public void ModsLoaded (FMLPostInitializationEvent event){
    	 packetPipeline.postInitialise();
    }
}
