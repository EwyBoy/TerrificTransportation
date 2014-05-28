package com.modjam.terrifictransportation.tileentitys;

import java.util.ArrayList;
import java.util.List;

import com.modjam.terrifictransportation.util.Modules;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ConveyorTile extends TileEntity {

	
	
	public List<com.modjam.terrifictransportation.util.Modules> installedModules = new ArrayList<com.modjam.terrifictransportation.util.Modules>();
	 private String ConveyorType = "Normal";
	    private int ConveyorTypeID = 0;

	    private int ModeNormal = 0;
	    private int ModeInport = 1;
	    private int ModeExport = 2;

	    public String getConveyorType() {
	        return ConveyorType;
	    }

	    public int getConveyorTypeID() {
	        return ConveyorTypeID;
	    }

	    public void setConveyorType(String type) {
	        ConveyorType = type;
	    }

	    private void setConveyorTypeID(int type) {
	        ConveyorTypeID = type;
	    }
	    public void changeConveyor(World world, EntityPlayer player) {
	        if(getConveyorTypeID() == 0) {
	            setConveyorType("Import Mode");
	            setConveyorTypeID(ModeInport);
	            playSoundEffect(world, player);
	            System.out.print("Its Done.");
	        } else if (getConveyorTypeID() == 1) {
	            setConveyorType("Export Mode");
	            setConveyorTypeID(ModeExport);
	            playSoundEffect(world, player);
	            System.out.print("Its Done.");
	        }else if (getConveyorTypeID() == 2) {
	            setConveyorType("Normal");
	            setConveyorTypeID(ModeNormal);
	            playSoundEffect(world, player);
	            System.out.print("Its Done.");
	        }
	    }
	    private void playSoundEffect(World world, EntityPlayer player) {

	        world.playSound(player.posX, player.posY, player.posZ, "tile.piston.in", 0.5F, 0.4F + 0.8F, false);
	    }
	 @Override
	    public void writeToNBT(NBTTagCompound nbt) {
	    	nbt.setString("conveyorType", ConveyorType);
	    	nbt.setInteger("conveyorTypeID", ConveyorTypeID);
	        nbt.setInteger("module1", installedModules.get(0).getModuleID(installedModules.get(0).name()));
	        nbt.setInteger("module2", installedModules.get(1).getModuleID(installedModules.get(1).name()));
	        nbt.setInteger("module3", installedModules.get(2).getModuleID(installedModules.get(2).name()));
	        nbt.setInteger("module4", installedModules.get(3).getModuleID(installedModules.get(3).name()));
	 }

    
	    
	    @Override
	    public void readFromNBT(NBTTagCompound nbt) {
	    	setConveyorType(nbt.getString("conveyorType"));
	    	setConveyorTypeID(nbt.getInteger("conveyorTypeID"));
	    	installedModules.clear();
	    	installedModules.add(getModuleByID(nbt.getInteger("module1")));
	    	installedModules.add(getModuleByID(nbt.getInteger("module2")));
	    	installedModules.add(getModuleByID(nbt.getInteger("module3")));
	    	installedModules.add(getModuleByID(nbt.getInteger("module4")));
	    }
    public Modules getModuleByID(int i){
    	if(i == 0){
    		return Modules.SPEED;
    	} else if (i == 1){
    		return Modules.CENTER;
    	}else{
    		return null;
    	}
    }
}
