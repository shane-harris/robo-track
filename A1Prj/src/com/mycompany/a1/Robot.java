package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Robot extends Moveable implements ISteerable {

	private int lives;
	private int maxSpeed;
	private int steeringDirection;
	private int energyLevel;
	private int damageLevel;
	private int lastBaseReached;
	private int energyConsumptionRate;
	private static Robot myRobot;

	private Robot(int speed, int heading, int size, int color, Point2D center) {
		super(speed, heading, size, color, center);
		// TODO Auto-generated constructor stub
		this.lives = 3;
		this.energyLevel = 100;
		this.damageLevel = 0;
		this.lastBaseReached = 1;
		this.energyConsumptionRate = 2;
		this.maxSpeed = 40;
		this.steeringDirection=0;
	}
	
	public static Robot getRobot(){
		if(myRobot == null) {
			Point2D center=null;
			center.setX(10/2);
			center.setY(10/2);
			myRobot = new Robot(10,0,10,ColorUtil.BLUE,center);
		}
		return myRobot;
	}

	public void steer(int direction) {

	}

	public int getMaxSpeed() {
		return this.maxSpeed;
	}

	public int getSteeringDirection() {
		return this.steeringDirection;
	}

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public int getDamageLevel() {
		return this.damageLevel;
	}

	public int getLastBaseReached() {
		return this.lastBaseReached;
	}

	public String toString() {
		String parentOutput = super.toString();
		String output;
		output = "maxSpeed=" + this.getMaxSpeed() + ", steeringDirection=" + this.getSteeringDirection()
				+ ", energyLevel= " + this.getEnergyLevel()+", damageLevel="+this.getDamageLevel()+"\n";
		return parentOutput + output;
	}

	public void move() {

	}

}
