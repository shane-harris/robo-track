package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * This class implements a Drone object. This class extends the Moveable object
 * class. 
 * @author Shane Harris
 * @version 1.0
 *
 */
public class Drone extends Moveable{
	private final int MAX_HEADING = 10;
	private final int MIN_HEADING =  1;
	private final int attackPower;
	private final static int MAX_SPEED = 50;
	private final static int size = 4;
	
	/**
	 * This constructs a Drone object of size=4
	 * color=Black, Speed=50 and with a random
	 * heading and location
	 */
	public Drone() {
		super(MAX_SPEED, 0, size, ColorUtil.BLACK, setLocation());
		Random ran = new Random();
		this.setHeading(ran.nextInt(360)); //sets random heading for
		this.attackPower = 10;
	}
	
	/**
	 * Returns the current attack power of this Drone object
	 * @return Integer of attack power value 10
	 */
	public int getAttack(){
		return this.attackPower;
	}
	
	/**
	 * This method generates a random heading for this Drone object
	 * this method also detects if this Drone has flown outside the 
	 * boundaries of the GameWorld. If this Drone objects location
	 * is at a GameWorld bourdary its heading is immediately 
	 * changed to ensure this Drone Stays contained.
	 */
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
	
	/**
	 * Sets a random location for this Drone upon inialization
	 * this method is called by this Drones constructor
	 * @return Point2D variable with random location within GameWorld
	 */
	private static Point2D setLocation(){
		Random rn = new Random();
		Point2D center= new Point2D(rn.nextDouble()*1024, rn.nextDouble()*768);
		return center;
	}
	
	/**
	 * This method ensures that this Drone's color
	 * cannot be changed if the setColor() method
	 * is called.
	 */
	public void setColor(int color) {
		super.setColor(super.getColor());
	}
	
	/**
	 * Overrides: toString() in Moveable This method calls the toString method in
	 * Moveable and adds this Drone's name to the string that was returned from the
	 * super.toString() call.
	 * 
	 * @return String containing all the relevent paramaters of this Drone Object.
	 *         Speed, heading, size, color, location.
	 */
	public String toString() {
		String parentOutput = "Drone: ";
		       parentOutput += super.toString();
		String output;
		output ="\n";
		return parentOutput + output;
	}

}
