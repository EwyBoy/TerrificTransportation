package com.modjam.terrifictransportation.util;

public enum Modules {

	SPEED (0, "Speed"),
	CENTER (1, "Center");

	private Modules(int i, String s){
		
	}

	public Modules getModuleByID(int i){
		if(i == 0){
			return SPEED;
		}else if (i == 1){
		return CENTER;
		}else{
			return null;
		}
	}
	public int getModuleID(String s){
		if(s.equalsIgnoreCase("Speed")){
		return 0;
		}else if (s.equalsIgnoreCase("Center")){
			return 1;
		}else{
			return 15;
		}
	}
}
