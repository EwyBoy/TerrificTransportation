package com.modjam.terrifictransportation.Render;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.modjam.terrifictransportation.Blocks.Technical.Blocks;
import com.modjam.terrifictransportation.Models.Coveyor;
import com.modjam.terrifictransportation.Models.CoveyorHollow;
import com.modjam.terrifictransportation.Models.CoveyorImportExport;
import com.modjam.terrifictransportation.Models.CoveyorTurn;
import com.modjam.terrifictransportation.Texture.TextureHandler;
import com.modjam.terrifictransportation.tileentitys.ConveyorTile;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ConveyorRenderer extends TileEntitySpecialRenderer {

   

    public ConveyorRenderer () {
       
    }

        public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float idk) {
            GL11.glPushMatrix();
            
            GL11.glTranslatef((float)x, (float)y, (float)z);
            ConveyorTile tileEntityYour = (ConveyorTile)tileEntity;
         
            renderConveyor(tileEntityYour, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, Blocks.Conveyor);
            GL11.glPopMatrix();
        }
    
      
        public void renderConveyor(ConveyorTile tl, World world, int x, int y, int z, Block block) {
            int dir = world.getBlockMetadata(x, y, z);
      
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.5F, -1.5F, 0.5F);
            GL11.glRotatef(dir * (-90F), 0F, 1F, 0F);
            if(world.getTileEntity(x, y +1, z + 1)instanceof ConveyorTile){
                
            	GL11.glRotatef(-224F, 0F, 0F, 1F);
            	GL11.glTranslatef(0.6F, 0F, 0F);
            	GL11.glRotatef(-180F, 1F, 0F,0F);
            	GL11.glTranslatef(0F, -0.8F, 0F);
        	    GL11.glScalef(1.5F, 1F, 1F);
            }
            if (world.getTileEntity(x, y, z+1) instanceof ConveyorTile && world.getTileEntity(x+1, y, z) instanceof ConveyorTile || world.getTileEntity(x, y, z-1) instanceof ConveyorTile && world.getTileEntity(x-1, y, z) instanceof ConveyorTile || world.getTileEntity(x, y, z+1) instanceof ConveyorTile && world.getTileEntity(x-1, y, z) instanceof ConveyorTile || world.getTileEntity(x, y, z-1) instanceof ConveyorTile && world.getTileEntity(x+1, y, z) instanceof ConveyorTile){
            	GL11.glRotatef(-90F, 0F, 1F, 0F);
         
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TextureHandler.texturePath + ":textures/blocks/ConveyorModelUiversal.png"));
            if(world.getTileEntity(x, y - 1, z) instanceof TileEntityHopper){
           	CoveyorHollow ch = new CoveyorHollow();
           	ch.render(0.0625F);
            }else{
            if(world.getTileEntity(x, y, z - 1) instanceof IInventory ||world.getTileEntity(x, y, z + 1) instanceof IInventory || world.getTileEntity(x + 1, y, z ) instanceof IInventory || world.getTileEntity(x - 1, y, z) instanceof IInventory){
            	CoveyorImportExport cie = new CoveyorImportExport();
            	cie.render(0.0625F);
            }else if (world.getTileEntity(x, y, z+1) instanceof ConveyorTile && world.getTileEntity(x+1, y, z) instanceof ConveyorTile || world.getTileEntity(x, y, z-1) instanceof ConveyorTile && world.getTileEntity(x-1, y, z) instanceof ConveyorTile || world.getTileEntity(x, y, z+1) instanceof ConveyorTile && world.getTileEntity(x-1, y, z) instanceof ConveyorTile || world.getTileEntity(x, y, z-1) instanceof ConveyorTile && world.getTileEntity(x+1, y, z) instanceof ConveyorTile){
            	CoveyorTurn ct = new CoveyorTurn();
            	ct.render(0.0625F);
            	
            }
            else{
            	Coveyor c = new Coveyor();
            	c.render(0.0625F);
            	
            }
            
            }
            
            
            GL11.glPopMatrix();
           
        }
    
}