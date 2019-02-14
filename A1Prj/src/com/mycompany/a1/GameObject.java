package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {
	private double posX;
	private double posY;
	private Point2D center;
	private int color;
	private int size;

	public GameObject(int size, int color, Point2D center) {
		this.size = size;
		this.color = color;
		this.center = center;
		this.posX = center.getX();
		this.posY = center.getY();
	}

	public Point2D getLocation() {
		return this.center;
	}

	public int getSize() {
		return this.size;
	}

	public int getColor() {
		return this.color;
	}
	
	public void setColor(int color){
		this.color = color;
	}

	public String toString() {
		String output;
		output = "Loc=" + this.getLocation().getX() + "," + this.getLocation().getY() + " color=" + "["
				+ ColorUtil.red(this.getColor()) + "," + ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor())
				+ "] size="+this.getSize()+" ";
		return output;
	}

}
