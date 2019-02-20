package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
/**
 * This class implements a Base object. This class
 * extends the Fixed object class
 * @author Shane Harris
 * @version 1.0
 *
 */
public class Base extends Fixed{
	final static int size=10;
	private int sequenceNumber;

	/**
	 * This constructs a Base with a specific Size, Color, Location, and Sequence number.
	 * @param center This is a Point2D variable that represents
	 * the center of this object and it location within the GameWorld
	 * @param sequenceNumber Unique number that represents this Base
	 */
	public Base(Point2D center, int sequenceNumber) {
		super(size, ColorUtil.YELLOW, center);
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * The returns the sequence number of this Base
	 * @return this Base's sequence number
	 */
	public int getSequenceNumber(){
		return this.sequenceNumber;
	}
	//Even if called color is set to initialized color
	//could be considered bad practice
	/*public void setColor(int color){
		super.setColor(super.getColor());
	}*/
	
	/**
	 * Undefined function to prevent the location
	 * of Base objects to be changed after instantiation
	 */
	public void setLocation(){}
	
	/**
	 * Overrides: toString() in GameObject
	 * This method calls the toString method in GameObject and adds 
	 * this Base's sequence number to the string that was returned
	 * from the super.toString() call. 
	 * @return String containing all the relevent paramaters of this Base Object. Location, Size, Color, Sequence Number
	 */
	public String toString() {
		String parentOutput = "Base: ";
		       parentOutput += super.toString();
		String output;
		output = "seqNum=" + this.getSequenceNumber()+"\n";
		return parentOutput + output;
	}

}
