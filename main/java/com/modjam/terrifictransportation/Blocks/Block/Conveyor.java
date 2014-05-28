package com.modjam.terrifictransportation.Blocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.modjam.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.modjam.terrifictransportation.Items.Item.Modules;
import com.modjam.terrifictransportation.Items.Item.Wrench;
import com.modjam.terrifictransportation.tileentitys.ConveyorTile;


public class Conveyor extends BlockContainer {

    public Conveyor() {
        super(Material.iron);
        setHardness(1F);
        setCreativeTab(TTCreativeTabs.ClockworkBlockTab);
    }
   
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    	int howmanyspeed = 1;
if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
	ConveyorTile cd = (ConveyorTile) world.getTileEntity(x, y, z);
	if(cd.installedModules.contains(com.modjam.terrifictransportation.util.Modules.SPEED)){
		
		if(cd.installedModules.get(0).equals(com.modjam.terrifictransportation.util.Modules.SPEED) && cd.installedModules.size() == 1){
			howmanyspeed++;
		}
		
		if(cd.installedModules.get(1).equals(com.modjam.terrifictransportation.util.Modules.SPEED)&& cd.installedModules.size() == 2){
			howmanyspeed++;
		}
		if(cd.installedModules.get(2).equals(com.modjam.terrifictransportation.util.Modules.SPEED)&& cd.installedModules.size() == 3){
			howmanyspeed++;
		}
		
	}
	
}
double entitySpeed = 0.025;
entitySpeed = entitySpeed * howmanyspeed;
        
        int meta = world.getBlockMetadata(x, y, z);
        int xAxis[] = {0,1,0,-1};
        int zAxis[] = {-1,0,1,0};
        double X = entity.posX;
        double Z = entity.posZ;

        if (xAxis[meta] == 0 & Math.abs(x + 0.5 - entity.posX) < 0.5 & Math.abs(x + 0.5 - entity.posX) > 0.1) {
           entity.motionX += Math.signum(x + 0.5 - entity.posX) * Math.min(entitySpeed, Math.abs(x + 0.5 - entity.posX)) / 1.2;
       }

        if (zAxis[meta] == 0 & Math.abs(x + 0.5 - entity.posZ) < 0.5 & Math.abs(x + 0.5 - entity.posZ) > 0.1 ) {
            entity.motionZ += Math.signum(x + 0.5 - entity.posZ) * Math.min(entitySpeed, Math.abs(x + 0.5 - entity.posZ)) / 1.2;
       }

        if (!entity.isSneaking()) {

            if (world.getBlock(x, y - 1, z) == Blocks.ice || (world.getBlock(x, y - 1, z) == Blocks.packed_ice ||(world.getBlock(x, y - 1, z) == Blocks.soul_sand ))) {
                entity.addVelocity(0,0,0);
            } else {
            	if(world.getBlockMetadata(x, y, z) == 3 ){
            		entity.addVelocity(0, 0, -entitySpeed);
            	}else if (world.getBlockMetadata(x, y, z) == 0){
            		entity.addVelocity(- entitySpeed, 0, 0);
            	}else if(world.getBlockMetadata(x, y, z) == 1){
            		entity.addVelocity(0,  0, +entitySpeed);
            	}else if(world.getBlockMetadata(x, y, z) == 2){
            		entity.addVelocity(+entitySpeed, 0, 0);
            	}
                
                entity.stepHeight = 1F;
            }
        }
        if(entity instanceof EntityItem){
        
        	EntityItem et = (EntityItem) entity;
        if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
        	
        	ConveyorTile c = (ConveyorTile) world.getTileEntity(x, y, z);
        	if(c.getConveyorType() == "Import Mode"){
        		
        		Block router = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Router;
        		if(world.getTileEntity(x, y, z -1) instanceof IInventory || world.getBlock(x, y, z) == router){
        			IInventory inv = (IInventory) world.getTileEntity(x, y, z -1);
        			
        			
        		for(int i = 0; i < inv.getSizeInventory(); i++){
        			if(inv.getStackInSlot(i) == null){
        				inv.setInventorySlotContents(i, et.getEntityItem());
        				entity.setDead();
        				
        				return;
        			}else{
        			}
        		}
        		}
        	}
        	
        }
        }
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
       return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

   

   @Override
 public void setBlockBoundsForItemRender() {
    setBlockBounds(0F, 0F, 0F, 1F, 0.35F, 1F);
  }

//    @Override
//    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
//        setBlockBounds(0F, 0F, 0F, 1F, 0.2F, 1F);
//    }
//
//    @Override
//    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
//        setBlockBoundsBasedOnState(world, x, y, z);
//        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
//    }
//
//    @Override
//    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
//        setBlockBoundsBasedOnState(world, x, y, z);
//        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
//    }
//
//    @Override
//    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
//        setBlockBoundsBasedOnState(world, x, y, z);
//        return super.collisionRayTrace(world, x, y, z, start, end);
//    }

   
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
   if(!world.isRemote){
    	Item equipped = entityplayer.getCurrentEquippedItem() != null ? entityplayer.getCurrentEquippedItem().getItem() : null;
    if (equipped instanceof Wrench){

    	Wrench c = (Wrench) equipped;
    	if(c.getWrenchTypeID() == 2){
    		if(entityplayer.isSneaking()){
    			if(world.getTileEntity(x, y, z) instanceof ConveyorTile){

    	    		ConveyorTile cs = (ConveyorTile) world.getTileEntity(x, y, z);
    			if(cs.installedModules.size() ==4){
    				if(cs.installedModules.get(4) == com.modjam.terrifictransportation.util.Modules.SPEED){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules()));
    					cs.installedModules.remove(4);
    				}
    				if(cs.installedModules.get(4) == com.modjam.terrifictransportation.util.Modules.CENTER){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules(), 1));
    					cs.installedModules.remove(4);
    				}
    			}
    			if(cs.installedModules.size() ==3){
    				if(cs.installedModules.get(3) == com.modjam.terrifictransportation.util.Modules.SPEED){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules()));
    					cs.installedModules.remove(3);
    				}
    				if(cs.installedModules.get(3) == com.modjam.terrifictransportation.util.Modules.CENTER){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules(), 1));
    					cs.installedModules.remove(3);
    				}
    			}
    			if(cs.installedModules.size() ==2){
    				if(cs.installedModules.get(2) == com.modjam.terrifictransportation.util.Modules.SPEED){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules()));
    					cs.installedModules.remove(2);
    				}
    				if(cs.installedModules.get(2) == com.modjam.terrifictransportation.util.Modules.CENTER){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules(), 1));
    					cs.installedModules.remove(2);
    				}
    			}
    			if(cs.installedModules.size() ==1){
    				if(cs.installedModules.get(1) == com.modjam.terrifictransportation.util.Modules.SPEED){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules()));
    					cs.installedModules.remove(1);
    				}
    				if(cs.installedModules.get(1) == com.modjam.terrifictransportation.util.Modules.CENTER){
    					entityplayer.inventory.addItemStackToInventory(new ItemStack(new Modules(), 1));
    					cs.installedModules.remove(1);
    				}
    			}
    			}
    		}
    	if(world.getTileEntity(x, y, z) instanceof ConveyorTile){

    		ConveyorTile cs = (ConveyorTile) world.getTileEntity(x, y, z);
    		cs.changeConveyor(world, entityplayer);
    		entityplayer.addChatComponentMessage(new ChatComponentText("This Conveyor is now set to " + cs.getConveyorType()));
    	}
    	}else if(c.getWrenchTypeID() == 1){
    		if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
    			ConveyorTile cs = (ConveyorTile) world.getTileEntity(x, y, z);
    			if(world.getBlockMetadata(x, y, z) == 0){
    				world.setBlockMetadataWithNotify(x, y, z, 1,3);
    			}else if(cs.getBlockMetadata() == 1){
    				world.setBlockMetadataWithNotify(x, y, z, 2,3);
    			}else if(cs.getBlockMetadata() == 2){
    				world.setBlockMetadataWithNotify(x, y, z, 3,3);
    			}else if(cs.getBlockMetadata() == 3){
    				world.setBlockMetadataWithNotify(x, y, z, 0,3);
    			}
    		}
    	}
    }else{
    	
    }
    if(equipped instanceof com.modjam.terrifictransportation.Items.Item.Modules){
    	com.modjam.terrifictransportation.Items.Item.Modules module = (Modules) equipped;
    	ItemStack m = entityplayer.getCurrentEquippedItem();
    	if(module.getDamage(m) == 0){
    		if(world.getTileEntity(x, y, z) instanceof ConveyorTile){

        		ConveyorTile cs = (ConveyorTile) world.getTileEntity(x, y, z);
    		if(cs.installedModules.size() == 3){
    			entityplayer.addChatMessage(new ChatComponentText("This Conveyor has no more Space!"));
    		}else{
    			cs.installedModules.add(com.modjam.terrifictransportation.util.Modules.SPEED);
    			entityplayer.inventory.getCurrentItem().stackSize = entityplayer.inventory.getCurrentItem().stackSize--;
    		}
    		}
    	}
    }
    }
	return true;
    
    }
    
@Override
    public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ){
if(world.getTileEntity(x, y, z) instanceof ConveyorTile){
	ConveyorTile c = (ConveyorTile) world.getTileEntity(x, y, z);
	if(c.getConveyorTypeID() == 2){
		Block router = com.modjam.terrifictransportation.Blocks.Technical.Blocks.Router;
		if(world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x, y, z) == router)){
			IInventory inv = (IInventory) world.getTileEntity(x, y, z + 1);
			
			
		for(int i = 0; i < inv.getSizeInventory(); i++){
			if(inv.getStackInSlot(i) == null){
				
			}else{
				world.getTileEntity(x, y, z +1).getWorldObj().spawnEntityInWorld(new EntityItem(world.getTileEntity(x, y, z + 1).getWorldObj(), x +1, y, z, inv.getStackInSlot(i).copy()));
				inv.setInventorySlotContents(i, null);
				
				
			}
		}
		}
	}
	
}
}

@Override
public TileEntity createNewTileEntity(World var1, int var2) {
	// TODO Auto-generated method stub
	return new ConveyorTile();
}
		@Override
public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
{
    return null;
}
		@Override
		 public MovingObjectPosition collisionRayTrace(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_)
		    {
		        this.setBlockBoundsBasedOnState(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
		        return super.collisionRayTrace(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
		    }
	@Override 
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item){
		 int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
	        System.out.print(dir);
	        if(world.getTileEntity(x, y +1, z + 1)instanceof ConveyorTile){
	        	this.setBlockBounds(0F, 0F, 0F, 1F, 0.35F, 1F);


	        }
	}



}
