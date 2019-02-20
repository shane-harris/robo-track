package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;

/**
 * This class implements a Fixed GameWorld object. This class
 * extends the GameWorld object class
 * @author Shane Harris
 * @version 1.0
 *
 */
public abstract class Fixed extends GameObject{
	
	/**
	 * This constructs a fixed GameWorld object
	 * @param size the size of the object, size is the length of one side of the 4 sided GameWorld object
	 * @param color the color of the object
	 * @param center the center and the location of the Fixed GameWorld object
	 */
	public Fixed(int size, int color, Point2D center) {
		super(size, color, center);
	}

}
