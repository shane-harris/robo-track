package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Drone extends Moveable{
	private final int MAX_HEADING = 10;
	private final int MIN_HEADING =  1;
	private final int attackPower;
	private final static int MAX_SPEED = 50;
	private final static int size = 4;
	
	//Drone is initialized with 0 heading then heading is changed.
	//This could also be a bad practice.
	public Drone() {
		super(MAX_SPEED, 0, size, ColorUtil.BLACK, setLocation());
		Random ran = new Random();
		this.setHeading(ran.nextInt(360)); //sets random heading for
		this.attackPower = 10;
	}
	
	public int getAttack(){
		return this.attackPower;
	}
	
	public void randomHeading() {
		final Point2D upperBound = new Point2D(0,0);
		final Point2D lowerBound = new Point2D(1024,768);
		if(this.getLocation().getX() <= upperBound.getX()) {
			//drone has flown too far to the right must about face
			super.adjustHeading(90);
			return;
		}
		if(this.getLocation().getX() >= lowerBound.getX()) {
			//drone has flown too far to the left 
			super.adjustHeading(270);
			return;
		}
		if(this.getLocation().getY() <= upperBound.getY()) {
			//drone has flown too far up
			super.adjustHeading(180);
			return;
		}
		if(this.getLocation().getY() >= lowerBound.getY()) {
			//drone has flown too far south
			super.adjustHeading(0);
			return;
		}
		Random rand = new Random();
		int randomHeading = rand.nextInt(MAX_HEADING) + MIN_HEADING;
		if(rand.nextInt(1)==0) //Deciding to add or subtract from heading
			randomHeading = randomHeading * (-1);
		super.adjustHeading(randomHeading);		
	}
	
	private static Point2D setLocation(){
		Random rn = new Random();
		Point2D center= new Point2D(rn.nextDouble()*1024, rn.nextDouble()*768);
		return center;
	}
	
	//Even if called color is set to initialized color
	//could be considered bad practice
	public void setColor(int color) {
		super.setColor(super.getColor());
	}
	
	public String toString() {
		String parentOutput = "Drone: ";
		       parentOutput += super.toString();
		String output;
		output ="\n";
		return parentOutput + output;
	}

}
