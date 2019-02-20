package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * This class implements a GameObject object.
 * 
 * @author Shane Harris
 * @version 1.0
 *
 */
public abstract class GameObject {
	private double posX;
	private double posY;
	private Point2D center;
	private int color;
	private int size;

	/**
	 * This constructs a GameObject with size, color, and a location
	 * 
	 * @param size   the length of one side of this GameObject
	 * @param color  the color of this GameObject
	 * @param center the location and the center of this GameObject
	 */
	public GameObject(int size, int color, Point2D center) {
		this.size = size;
		this.color = color;
		this.center = center;
		this.posX = center.getX();
		this.posY = center.getY();
	}

	/**
	 * Returns the current location of this GameObject
	 * 
	 * @return Point2D variable representing this GameObject's current location
	 */
	public Point2D getLocation() {
		return this.center;
	}

	/**
	 * Returns the length of one side of this GameObject
	 * 
	 * @return the size of this GameObject
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Returns the color of this GameObject
	 * 
	 * @return the color of this GameObject's interger value
	 */
	public int getColor() {
		return this.color;
	}

	/**
	 * Sets the color of this GameObject
	 * 
	 * @param color the integer value of this GameObjects color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Sets the location of this GameObject
	 * 
	 * @param center the new location of this GameObject
	 */
	public void setLocation(Point2D center) {
		this.center = center;
	}

	/**
	 * Overrides: toString() in Object This method compiles this GameObject's
	 * location then formats the double to only print up to one decimal place, then
	 * takes this GameObjects color and prints the RGB values, and prints the size
	 * of the GameObject
	 * 
	 * @return String containing all the relevent paramaters of this GameObject.
	 *         Location, Size, Color/
	 */
	public String toString() {
		String output = null;
		output = "loc=" + Math.round(this.getLocation().getX() * 10.0) / 10.0 + ", "
				+ Math.round(this.getLocation().getY() * 10.0) / 10.0 + " color=" + "[" + ColorUtil.red(this.getColor())
				+ ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) + "] size="
				+ this.getSize() + " ";
		return output;
	}

}
