package com.modjam.terrifictransportation.Blocks.Technical;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import com.modjam.terrifictransportation.Blocks.Block.Conveyor;

import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks {

    public static Block Conveyor;
    public static Block Router;
    public static TileEntity ConveyorTile;

    public static void init() {
        registerBlocks();
    }

    public static void registerBlocks() {

        Conveyor = new Conveyor().setBlockName(BlockInfo.ConveyorBlockName);
        GameRegistry.registerBlock(Conveyor, BlockInfo.ConveyorKey);

        Router = new com.modjam.terrifictransportation.Blocks.Block.Router().setBlockName(BlockInfo.RouterBlockName);
        GameRegistry.registerBlock(Router, BlockInfo.RouterKey);

        ConveyorTile = new com.modjam.terrifictransportation.tileentitys.ConveyorTile();
        GameRegistry.registerTileEntity(com.modjam.terrifictransportation.tileentitys.ConveyorTile.class, "conveyorTile");
    }
}
