package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class EnergyStation extends Fixed{
	private int capacity;
	

	public EnergyStation() {
		super(setSize(), ColorUtil.GREEN, setLocation());
		this.capacity = super.getSize();
	}
	
	//Creating random size of energyStation
	private static int setSize(){
		Random rn = new Random();
		return (rn.nextInt(50)+10);
	}
	
	//Creating random initial location for energy stations
	private static Point2D setLocation(){
		Random rn = new Random();
		Point2D center= new Point2D(rn.nextDouble()*1024,rn.nextDouble()*768);
		return center;
	}
	
	//Method to be called in GameWorld if EnergyStation
	//location == Robot Location
	public int getCapacity(){
		return this.capacity;
	}
	
	//Method to be called in GameWorld if EnergyStation
	//location == Robot Location
	public void transferEnergy(){
		this.setColor(ColorUtil.GRAY);
		this.capacity = 0;
	}
	
	//This method is called when Robot dies and game is rest
	public void resetCapacity(){
		this.capacity = super.getSize();
	}

}
