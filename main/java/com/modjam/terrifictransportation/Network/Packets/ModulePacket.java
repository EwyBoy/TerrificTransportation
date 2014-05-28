package com.modjam.terrifictransportation.Network.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class ModulePacket extends AbstractPacket{

	public static int moduleID;
	public ModulePacket(){
		
	}
	public ModulePacket(int moduleid){
		this.moduleID = moduleid;
	}
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(moduleID);
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
	moduleID = buffer.readInt();
		
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		
		
	}

}
