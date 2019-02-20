package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Robot extends Moveable implements ISteerable {

	final static int size = 10;
	final int MAX_HEADING = 40;
	final int MIN_HEADING = -40;
	final int MAX_ENERGY = 100;
	final int MAX_DAMAGE = 100;
	private final int energyConsumptionRate;
	private int maxSpeed;
	private int steeringDirection;
	private int energyLevel;
	private int damageLevel;
	private int lastBaseReached;
	private static Robot myRobot;

	// Private constructor prevents multiple instances of Robot
	private Robot(int speed, int heading, int size, int color, Point2D center) {
		super(speed, heading, size, color, center);
		this.energyLevel = 100;
		this.damageLevel = 0;
		this.lastBaseReached = 1;
		this.energyConsumptionRate = 2;
		this.maxSpeed = 40;
		this.steeringDirection = 0;
	}

	// Method called to instanciate a Robot object if none exist
	public static Robot getRobot() {
		if (myRobot == null) {
			Point2D center = new Point2D(0, 0);
			// center.setX(size/2);
			// center.setY(size/2);
			myRobot = new Robot(10, 0, size, ColorUtil.BLUE, center);
		}
		return myRobot;
	}

	public int getMaxSpeed() {
		return this.maxSpeed;
	}

	public int getSteeringDirection() {
		return this.steeringDirection;
	}

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public int getDamageLevel() {
		return this.damageLevel;
	}

	public int getLastBaseReached() {
		return this.lastBaseReached;
	}

	public void updateLastBaseReached() {
		this.lastBaseReached++;
	}

	private void setDamageLevel(int damage) {
		this.damageLevel = damage;
	}

	private void setEnergyLevel(int charge) {
		this.energyLevel = charge;
	}

	private void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	private void setSteeringDirection(int steeringDirection) {
		this.steeringDirection = steeringDirection;
	}

	// will accelorate robot
	public void accelorateRobot(int accelerate) {
		if (this.getEnergyLevel() > 0) {
			if (this.getSpeed() + accelerate >= this.getMaxSpeed())
				super.setSpeed(this.getMaxSpeed());
			else if (this.getSpeed() + accelerate <= 0)
				super.setSpeed(0);
			else
				super.setSpeed(this.getSpeed() + accelerate);
		}
	}

	// Robot Color will change depending on the amount of damage it has sustained
	public void applyDamage(int damage) {
		this.setDamageLevel(this.getDamageLevel() - damage);

		this.setMaxSpeed(40 - (40 * (this.getDamageLevel() / 100)));

		if (this.getSpeed() > this.getMaxSpeed())
			super.setSpeed(this.getMaxSpeed());

		if (this.getDamageLevel() < 75 && this.getDamageLevel() > 50) {
			this.setColor(ColorUtil.rgb(137, 207, 240));
		}
		if (this.getDamageLevel() < 49 && this.getDamageLevel() > 15) {
			this.setColor(ColorUtil.rgb(255, 165, 0));
		}
		if (this.getDamageLevel() < 14) {
			this.setColor(ColorUtil.rgb(255, 0, 0));
		}
	}

	// Increases Robot energy level but will not excede maximum level
	public void chargeRobot(int charge) {
		if (this.getEnergyLevel() + charge > MAX_ENERGY)
			this.setEnergyLevel(MAX_ENERGY);
		else
			this.setEnergyLevel(this.getEnergyLevel() + charge);
	}

	public void consumeEnergy() {
		this.setEnergyLevel(this.getEnergyLevel() - this.energyConsumptionRate);
	}

	// There is a more elegant way to do this. Make correction when not sleepy
	/*public void adjustHeading(int direction) {
		super.adjustHeading(this.getHeading() + direction);
	}*/

	// Will only accept direction incruments of 5; max 40 min -40
	public void steer(int direction) {
		if (direction == 5 || direction == -5) {
			if ((this.getSteeringDirection() + direction) >= MIN_HEADING
					&& (this.getSteeringDirection() + direction) <= MAX_HEADING)
				this.setSteeringDirection(this.getSteeringDirection() + direction);
		}
	}
	
	public void move(){
		super.adjustHeading(this.getSteeringDirection());
		super.move();
	}

	public String toString() {
		String parentOutput = "Robot: ";
		parentOutput += super.toString();
		String output;
		output = "maxSpeed=" + this.getMaxSpeed() + ", steeringDirection=" + this.getSteeringDirection()
				+ ", energyLevel= " + this.getEnergyLevel() + ", damageLevel=" + this.getDamageLevel() + "\n";
		return parentOutput + output;
	}

}
