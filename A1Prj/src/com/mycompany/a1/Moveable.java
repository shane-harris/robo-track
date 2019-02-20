package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;

/**
 * This class implements a Moveable GameWorld object. This class
 * extends the GameWorld object class
 * @author Shane Harris
 * @version 1.0
 *
 */
public abstract class Moveable extends GameObject{
	private int heading;
	private int   speed;
	
	/**
	 * This constructs a Moveable object with a specified
	 * speed, heading, size, color, and location.
	 * 
	 * @param speed   the initial speed of this Moveable object
	 * @param heading the initial heading of this Moveable object
	 * @param size    the length of one side of this Moveable object
	 * @param color   the initial color of this Moveable object
	 * @param center  The initial location of this Moveable object
	 */
	public Moveable(int speed, int heading, int size, int color, Point2D center) {
		super(size, color, center);
		this.speed = speed;
		this.heading = heading;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHeading(){
		return this.heading;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public void setHeading(int heading){
		this.heading = heading;
	}
	
	public String toString() {
		String ParentOutput = super.toString();
		String output;
		output = "heading="+this.getHeading()+" speed="+this.getSpeed()+" ";
		return ParentOutput + output;
	}
	public void move(){
		Point2D oldLocation = this.getLocation();
		double deltaX = oldLocation.getX() + Math.cos(Math.toRadians(90-this.getHeading()))*this.getSpeed();
		double deltaY = oldLocation.getY() + Math.sin(Math.toRadians(90-this.getHeading()))*this.getSpeed();
		if(deltaX < 0)
			deltaX = 0;
		if(deltaX > 1024)
			deltaX =1024;
		if(deltaY < 0)
			deltaY = 0;
		if(deltaY > 768)
			deltaY = 768;
		this.setLocation(new Point2D(deltaX,deltaY));
		
	}
	
	public void adjustHeading(int direction){
		if(this.heading + direction > 359)
			this.heading = Math.abs(this.heading+direction) - 360;
		if(this.heading + direction < 0)
			this.heading = 360 - Math.abs(this.heading + direction);
		else
			this.heading = this.heading + direction;
	}

}
