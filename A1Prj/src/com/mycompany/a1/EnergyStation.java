package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * This class implements a EnergyStation object. This class
 * extends the Fixed object class
 * @author Shane Harris
 * @version 1.0
 *
 */
public class EnergyStation extends Fixed{
	private int capacity;
	/**
	 * This constructs an EnergyStation object with a random size from 10 to 50,
	 * a random location withing GameWorld and the initial color is Green
	 * the capacity of this EnergyStation is equal to its size
	 */
	public EnergyStation() {
		super(setSize(), ColorUtil.GREEN, setLocation());
		this.capacity = super.getSize();
	}
	
	/**
	 * This returns a random size between 10 and 50
	 * @return random size to the constructor
	 */
	private static int setSize(){
		Random rn = new Random();
		return (rn.nextInt(50)+10);
	}
	
	/**
	 * This returns a random location for this EnergyStation object
	 * The location can be anywhere within the 1024x768 GameWorld
	 * @return Point2D variable containing the location and center of this EnergyStation
	 */
	private static Point2D setLocation(){
		Random rn = new Random();
		Point2D center= new Point2D(rn.nextDouble()*1024,rn.nextDouble()*768);
		return center;
	}
	
	/**
	 * This returns the capacity of this EnergyStation
	 * @return the current capacity of this EnergyStation
	 */
	public int getCapacity(){
		return this.capacity;
	}
	
	/**
	 * This method sets the capacity of this EnergyStation to zero
	 * and changes the color of this EnergyStation to Gray.
	 * This method is called when the Robot collides with this
	 * EnergyStation
	 */
	public void transferEnergy(){
		this.setColor(ColorUtil.GRAY);
		this.capacity = 0;
	}
	
	/**
	 * This method resets the capacity of this EnergyStation to its
	 * original value. This method is only called when the Robot
	 * dies and the game is reset.
	 */
	public void resetCapacity(){
		this.capacity = super.getSize();
	}
	
	/**
	 * Overrides: toString() in GameObject
	 * This method calls the toString method in GameObject and adds 
	 * this EnergyStation's capacity to the string that was returned
	 * from the super.toString() call. 
	 * @return String containing all the relevent paramaters of this EnergyStation Object. Location, Size, Color, Capacity
	 */
	public String toString() {
		String parentOutput = "EnergyStation: ";
			   parentOutput += super.toString();
		String output;
		output = "capacity=" + this.getCapacity()+"\n";
		return parentOutput + output;
	}

}
