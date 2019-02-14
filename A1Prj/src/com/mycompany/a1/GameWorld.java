package com.mycompany.a1;

import java.util.ArrayList;

public class GameWorld {
	private ArrayList<GameObject> gameObjects;
	private double width;
	private double height;
	private double originX;
	private double originY;
	private int clock;
	private int lives;
	
	public GameWorld() {
		this.width   = 1024.0;
		this.height  = 768.0;
		this.originX = 0.0;
		this.originY = 0.0;
		
	}
	
	public void init() {
		gameObjects = new ArrayList<GameObject>();
		this.lives   = 3;
		this.clock   = 0;
		
		
	}
	
	public void display() {
		
	}
	
	public void map() {
		
	}
	
	public void update() {
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
	

}
