package com.modjam.terrifictransportation.Network.Proxies;

import com.modjam.terrifictransportation.Blocks.Technical.BlockInfo;
import com.modjam.terrifictransportation.Render.ConveyorRenderer;
import com.modjam.terrifictransportation.Render.ConveyorRendererX;
import com.modjam.terrifictransportation.Render.RouterRender;
import com.modjam.terrifictransportation.tileentitys.ConveyorTile;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public void initRenders() {

        ConveyorRenderer conveyorRenderer = new ConveyorRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(ConveyorTile.class, conveyorRenderer);



        RouterRender routerRender = new RouterRender();
        RenderingRegistry.registerBlockHandler(routerRender);
        BlockInfo.RouterRenderID = routerRender.getRenderId();
    }

}
