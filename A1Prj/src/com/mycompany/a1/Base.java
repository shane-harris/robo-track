package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Base extends Fixed{
	final static int size=10;
	private int sequenceNumber;

	public Base(Point2D center, int sequenceNumber) {
		super(size, ColorUtil.YELLOW, center);
		this.sequenceNumber = sequenceNumber;
	}
	
	public int getSequenceNumber(){
		return this.sequenceNumber;
	}
	//Even if called color is set to initialized color
	//could be considered bad practice
	public void setColor(int color){
		super.setColor(super.getColor());
	}
	
	//Testing out setLocation method with no definition
	public void setLocation(){}
	
	public String toString() {
		String parentOutput = "Base: ";
		       parentOutput += super.toString();
		String output;
		output = "seqNum=" + this.getSequenceNumber()+"\n";
		return parentOutput + output;
	}

}
