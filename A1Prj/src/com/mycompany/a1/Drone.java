package com.mycompany.a1;

import java.util.Random;

import com.codename1.ui.geom.Point2D;

public class Drone extends Moveable{
	
	public Drone(int speed, int heading, int size, int color, Point2D center) {
		super(speed, heading, size, color, center);
		
	}
	
	public void adjustHeading() {
		Random rand = new Random();
		double rn = rand.nextDouble() * 10 + 1;
		if(rand.nextInt(1)==0) //Deciding to add or subtract from heading
			rn = rn * (-1);
		
		
	}

}
