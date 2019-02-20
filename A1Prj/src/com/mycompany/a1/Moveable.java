package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;

public abstract class Moveable extends GameObject{
	private int heading;
	private int   speed;
	private Point2D center;
	
	public Moveable(int speed, int heading, int size, int color, Point2D center) {
		super(size, color, center);
		this.speed = speed;
		this.heading = heading;
		
	}
	
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
		Point2D newCenter= new Point2D(deltaX,deltaY);
		this.setLocation(newCenter);
		
	}
	
	public void adjustHeading(int direction){
		if(this.heading + direction > 359)
			this.heading = Math.abs(this.heading+direction) - 360;
		if(this.heading + direction < 0)
			this.heading = 360 - Math.abs(this.heading + direction);
		else
			this.heading = this.heading + direction;
	}
	
	//I do not know if this is the correct way to do this
	//I have center as a private variable in GameObject class
	//but because it gets modified when an object moves
	//i dont know if i should not have it as part of the 
	//game object constructor.
	/*private void setLocation(Point2D center){
		this.center = center;
	}*/

}
