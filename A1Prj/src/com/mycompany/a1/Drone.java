package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Drone extends Moveable{
	final int MAX_HEADING = 10;
	final int MIN_HEADING =  1;
	final static int MAX_SPEED = 50;
	final static int size = 4;
	
	//Drone is initialized with 0 heading then heading is changed.
	//This could also be a bad practice.
	public Drone() {
		super(MAX_SPEED, 0, size, ColorUtil.BLACK, setLocation());
		randomHeading();
	}
	
	public void randomHeading() {
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

}
