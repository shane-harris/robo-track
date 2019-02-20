package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;

/**
 * This class implements a Moveable GameWorld object. This class extends the
 * GameWorld object class
 * 
 * @author Shane Harris
 * @version 1.0
 *
 */
public abstract class Moveable extends GameObject {
	private int heading;
	private int speed;

	/**
	 * This constructs a Moveable object with a specified speed, heading, size,
	 * color, and location.
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
	 * Returns the heading of this Moveable object
	 * 
	 * @return the heading of this Moveable object
	 */
	public int getHeading() {
		return this.heading;
	}

	/**
	 * Returns the speed of this Moveable object
	 * 
	 * @return the speed of this Moveable object
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Sets the speed of this Moveable object
	 * 
	 * @param speed the new speed of this Moveable object
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Sets the heading of this Moveable object
	 * 
	 * @param heading the new heading of this Movable object
	 */
	public void setHeading(int heading) {
		this.heading = heading;
	}

	/**
	 * Overrides: toString() in GameObject This method calls the toString method in
	 * GameObject and adds this Moveable objects heading and speed to the string
	 * that was returned from the super.toString() call.
	 * 
	 * @return String containing all the relevent paramaters of this Moveable
	 *         object. Location, Size, Color, Speed and Heading
	 */
	public String toString() {
		String ParentOutput = super.toString();
		String output;
		output = "heading=" + this.getHeading() + " speed=" + this.getSpeed() + " ";
		return ParentOutput + output;
	}

	/**
	 * This method changed the location of this Moveable object. This method uses
	 * this Moveable objects current location, speed and heading to determine this
	 * Moveable objects new location. This methos will also not allow this Moveable
	 * objects new location to be outside the GameWorlds boundaries og 1024x768. If
	 * the calculations resuls in coordinates outside the GameWorld's boundaries the
	 * values are forced to not go beyond the boundaries
	 * 
	 * @param deltaX this Moveable objects X coordinate minimum value 0 maximum
	 *               value 1024
	 * @param deltaY this Moveable objects Y coordinate minimum value 0 maximum
	 *               value 768
	 */
	public void move() {
		Point2D oldLocation = this.getLocation();
		double deltaX = oldLocation.getX() + Math.cos(Math.toRadians(90 - this.getHeading())) * this.getSpeed();
		double deltaY = oldLocation.getY() + Math.sin(Math.toRadians(90 - this.getHeading())) * this.getSpeed();
		if (deltaX < 0)
			deltaX = 0;
		if (deltaX > 1024)
			deltaX = 1024;
		if (deltaY < 0)
			deltaY = 0;
		if (deltaY > 768)
			deltaY = 768;
		this.setLocation(new Point2D(deltaX, deltaY));
	}

	/**
	 * This method adjust the heading of this Moveable object This method prevents
	 * the heading variable from being less than 0 or greater than 360
	 * 
	 * @param direction the variable to which the heading is to be
	 *                  increases/decreased by
	 */
	public void adjustHeading(int direction) {
		if (this.heading + direction >= 360)
			this.heading = Math.abs(this.heading + direction) - 360;
		if (this.heading + direction < 0)
			this.heading = 360 - Math.abs(this.heading + direction);
		else
			this.heading = this.heading + direction;
	}

}
