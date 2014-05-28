package com.modjam.terrifictransportation.Render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class RouterRender implements ISimpleBlockRenderingHandler {

    private int ID;

    public RouterRender() {
        ID = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);

        GL11.glPushMatrix();

        GL11.glRotatef(90, 0, 1, 0);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads(); // Tell it to draw a new thing
        tessellator.setNormal(0.0F, -1.0F, 0.0F); //Direction to render stuff, like a dize -1 = bot
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata)); //block, pos, texture
        tessellator.draw();  //Finish draw

        tessellator.startDrawingQuads();
        tessellator.setNormal(0F, 1F, 0F);
        renderer.renderFaceYPos(block, 0, 0, 0, block.getIcon(1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
        tessellator.draw();

        GL11.glPopMatrix();
    }

    private void defaultRender(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0.20F, 0F, 0.20F, 0.80F, 0.80F, 0.80F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderSidePosX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0.75F, 0.20F, 0.30F, 1F, 0.60F, 0.70F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderSideNegX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0.25F, 0.20F, 0.70F, 0F, 0.60F, 0.30F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderSidePosZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0.25F, 0.20F, 0.75F, 0.75F, 0.60F, 1F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderSideNegZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        block.setBlockBounds(0.25F, 0.20F, 0F, 0.75F, 0.60F, 0.25F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderSideY(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Block conveyor = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Conveyor;

        if (world.getBlock(x, y + 1, z) == conveyor) {
            block.setBlockBounds(0.25F, 0.30F, 0.25F, 0.75F, 1F, 0.75F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y ,z);
        } else {
            block.setBlockBounds(0.30F, 0.30F, 0.30F, 0.70F, 1F, 0.70F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y ,z);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator.instance.setColorOpaque_F(1F, 1F, 1F);
        Block conveyor = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Conveyor;
        Block router = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Router;

        if (world.getBlock(x, y, z) == router) {
            defaultRender(world, x, y, z, block, modelId, renderer);

            if (world.getTileEntity(x + 1, y, z) instanceof IInventory || world.getBlock(x + 1, y, z) == conveyor || (world.getBlock(x + 1, y, z)) == router) {
                renderSidePosX(world, x, y, z, block, modelId, renderer);
            }

            if (world.getTileEntity(x - 1, y, z) instanceof IInventory || world.getBlock(x - 1, y, z) == conveyor || (world.getBlock(x - 1, y, z)) == router) {
                renderSideNegX(world, x, y, z, block, modelId, renderer);
            }

            if (world.getTileEntity(x, y, z + 1) instanceof IInventory || world.getBlock(x, y, z + 1) == conveyor || (world.getBlock(x, y, z + 1)) == router) {
                renderSidePosZ(world, x, y, z, block, modelId, renderer);
            }

            if (world.getTileEntity(x, y, z - 1) instanceof IInventory || world.getBlock(x, y, z - 1) == conveyor || (world.getBlock(x, y, z - 1)) == router) {
                renderSideNegZ(world, x, y, z, block, modelId, renderer);
            }

            if (world.getTileEntity(x, y + 1, z) instanceof IInventory || world.getBlock(x, y + 1, z) == conveyor || (world.getBlock(x, y + 1, z)) == router) {
                renderSideY(world, x, y, z, block, modelId, renderer);
            }
        }
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return ID;
    }
}
