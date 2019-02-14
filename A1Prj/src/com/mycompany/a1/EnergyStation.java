package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class EnergyStation extends Fixed{
	private int capacity;
	private int energyTransfered;
	

	public EnergyStation() {
		super(setSize(), ColorUtil.GREEN, setLocation());
		this.capacity = super.getSize();
		this.energyTransfered = 0;
	}
	
	//constructor to be called upon life lost of Robot
	//Uses old size and location and updates capacity if energy was 
	//transferd before life lost
	public EnergyStation(int size, Point2D center, int capacity, int energyTransfered){
		super(size, ColorUtil.GREEN, center);
		if(energyTransfered == 0)
			this.capacity = capacity;
		else
			this.capacity = energyTransfered;
	}
	
	private static int setSize(){
		Random rn = new Random();
		return (rn.nextInt(20)+10);
	}
	
	private static Point2D setLocation(){
		Random rn = new Random();
		Point2D center=null;
		center.setX(rn.nextDouble()*1024);
		center.setY(rn.nextDouble()*768);
		return center;
		
	}
	
	//Methods to be called in GameWorld if EnergyStation
	//location == Robot Location
	public int getCapacity(){
		return this.capacity;
	}
	public void transferEnergy(){
		this.energyTransfered = this.capacity;
		this.capacity = 0;
	}

}
