package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * This class implements a Robot object. This class extends the Moveable object
 * class and implements the ISteerable class This class utalizes a singleton
 * design pattern to ensure only one instance of Robot can be instantiated
 * 
 * @author Shane Harris
 * @version 1.0
 *
 */
public class Robot extends Moveable implements ISteerable {

	final static int SIZE = 10;
	final int MAX_HEADING = 40;
	final int MIN_HEADING = -40;
	final int MAX_ENERGY = 100;
	final int MAX_DAMAGE = 100;
	private final int ENERGY_CONSUMPTION_RATE;
	private int maxSpeed;
	private int steeringDirection;
	private int energyLevel;
	private int damageLevel;
	private int lastBaseReached;
	private static Robot myRobot;

	/**
	 * This private constructor ensures that no method outside this calss can access
	 * this constructor This constructs a single Robot object with a specified
	 * speed, heading, size, color, and location.
	 * 
	 * @param speed   the initial speed of this Robot is 10
	 * @param heading the initial heading of this Robot always 0
	 * @param size    the length of one side of this Robot final 10
	 * @param color   the initial color of this Robot BLUE
	 * @param center  The initial location of this Robot initialised to 0.0, 0.0
	 */
	private Robot(int speed, int heading, int size, int color, Point2D center) {
		super(speed, heading, size, color, center);
		this.energyLevel = 100;
		this.damageLevel = 0;
		this.lastBaseReached = 1;
		this.ENERGY_CONSUMPTION_RATE = 2;
		this.maxSpeed = 40;
		this.steeringDirection = 0;
	}

	/**
	 * This method ensures that only ONE instance of Robot can exist during the game
	 * This method checks to see if a Robot object exist. If not then one is created
	 * if one exist then this Robot is returned.
	 * 
	 * @return only one unique instance of Robot. If called gain then the same
	 *         instance is returned again.
	 */
	public static Robot getRobot() {
		if (myRobot == null) {
			Point2D center = new Point2D(0, 0);
			myRobot = new Robot(10, 0, SIZE, ColorUtil.BLUE, center);
		}
		return myRobot;
	}

	/**
	 * This method resets all the Robot parameters back to their initialized values
	 * This method is only called in the event that the Robot looses a life
	 */
	public void respawn() {
		this.setDamageLevel(0);
		this.setEnergyLevel(100);
		this.setLastBasereached(1);
		this.setMaxSpeed(40);
		this.setSteeringDirection(0);
		this.setSpeed(10);
		this.setColor(ColorUtil.BLUE);
		this.setLocation(new Point2D(0.0, 0.0));

	}

	/**
	 * Returns the current max speed of this Robot
	 * @return this Robots current max speed
	 */
	public int getMaxSpeed() {
		return this.maxSpeed;
	}

	/**
	 * Returns the current steering direction of this Robot
	 * @return this Robots current steering direction
	 */
	public int getSteeringDirection() {
		return this.steeringDirection;
	}

	/**
	 * Returns the current energy level of this Robot
	 * @return this Robots current energy level
	 */
	public int getEnergyLevel() {
		return this.energyLevel;
	}

	/**
	 * Returns the current damage level of this Robot
	 * @return this Robots current damage level
	 */
	public int getDamageLevel() {
		return this.damageLevel;
	}

	/**
	 * Returns the current last base reached by this Robot
	 * @return this Robots current last base reached
	 */
	public int getLastBaseReached() {
		return this.lastBaseReached;
	}

	/**
	 * This method itterated that last base reached by this Robot This method is
	 * called when this Robot collides with the next base in the sequence of Base
	 * objects
	 */
	public void updateLastBaseReached() {
		this.lastBaseReached++;
	}

	/**
	 * This method sets the damage level of this Robot this method is called when
	 * this Robot collides with a Drone object or another Robot object or if this
	 * Robot looses a life and is reset
	 * 
	 * @param damage the damage this Robot recieves from a collision or when reset
	 */
	private void setDamageLevel(int damage) {
		this.damageLevel = damage;
	}

	/**
	 * This method sets this Robots last Base reached variable This method is called
	 * if this Robot dies and the game is reset
	 * 
	 * @param lastBaseReached the last Base this Robot collided with in the Base
	 *                        object sequence
	 */
	private void setLastBasereached(int lastBaseReached) {
		this.lastBaseReached = lastBaseReached;
	}

	/**
	 * This method sets this Robots energy level This method is called when this
	 * Robot moves, collides with an EnergyStation objece or is reset
	 * 
	 * @param charge this robots new energy level
	 */
	private void setEnergyLevel(int charge) {
		this.energyLevel = charge;
	}

	/**
	 * This method sets this Robots maximum speed This method is called when this
	 * Robot recieves damage or is reset
	 * 
	 * @param maxSpeed the maximum speed of this Robot
	 */
	private void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * This method sets this Robots steering direction This method is called by the
	 * steer() method or when this Robot is reset
	 * 
	 * @param steeringDirection the current steering direction of this Robot
	 */
	private void setSteeringDirection(int steeringDirection) {
		this.steeringDirection = steeringDirection;
	}

	/**
	 * This method incrases/decreases this Robots speed This Robots speed is limited
	 * by this Robots maximum speed and cannot be less than zero
	 * 
	 * @param accelerate the ammount of speed to be added/subtracted from this
	 *                   Robots current speed
	 */
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

	/**
	 * This method adds damage to this Robot, lowers this Robot's maximum speed
	 * proportional to the damage this has recieved and changed this Robot's color
	 * baised on the ammount of damage this Robot has sustained. This method is
	 * called when this Robot collides with a Drone object or a Robot object
	 * 
	 * @param damage the ammount of damage this robot is sustaining
	 */
	public void applyDamage(int damage) {
		this.setDamageLevel(this.getDamageLevel() + damage);
		// Adjusting maxSpeed to be proportional to Robot Damage
		this.setMaxSpeed((int) (40.0 - (40.0 * ((double) this.getDamageLevel() / 100.0))));
		int newSpeed = (int) ((40 - (40 * ((double) this.getDamageLevel() / 100))));
		System.out.println("Max speed should be " + newSpeed + ".");

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

	/**
	 * This method increases the current charge of this Robot up to a maximum of 100
	 * This method is called when this Robot collides with an EnergyStation, the
	 * capacity of the EnergyStation object this Robot collides with is passed into
	 * this method.
	 * 
	 * @param charge the capacity of the EnergyStation this Robot collided with
	 */
	public void chargeRobot(int charge) {
		if (this.getEnergyLevel() + charge > MAX_ENERGY)
			this.setEnergyLevel(MAX_ENERGY);
		else
			this.setEnergyLevel(this.getEnergyLevel() + charge);
	}

	/**
	 * This method reduces this Robots energy level by a pre determined rate
	 * (energyConsumptionRate) This method is called once per clock tick()
	 */
	public void consumeEnergy() {
		this.setEnergyLevel(this.getEnergyLevel() - this.ENERGY_CONSUMPTION_RATE);
	}

	/**
	 * This method increases/decreases this Robots steering direction in incruments
	 * of 5 between a maximum of 40 (right) and a minimum of -40 (left)
	 */
	public void steer(int direction) {
		if (direction == 5 || direction == -5) {
			if ((this.getSteeringDirection() + direction) >= MIN_HEADING
					&& (this.getSteeringDirection() + direction) <= MAX_HEADING)
				this.setSteeringDirection(this.getSteeringDirection() + direction);
		}
	}

	/**
	 * This method adjust's this Robots heading in relation to this Robots steering
	 * direction then calles its supers move method to update this Robots location
	 */
	public void move() {
		super.adjustHeading(this.getSteeringDirection());
		super.move();
	}

	/**
	 * Overrides: toString() in Moveable This method calls the toString method in
	 * Moveable and adds this Robot's maximum speed, steering direction, energy
	 * level, and damage level to the string that was returned from the
	 * super.toString() call.
	 * 
	 * @return String containing all the relevent paramaters of this Robot Object.
	 *         Speed, heading, size, color, location, maxSpeed, steeringDirection,
	 *         energyLevel, and damageLevel.
	 */
	public String toString() {
		String parentOutput = "Robot: ";
		parentOutput += super.toString();
		String output;
		output = "maxSpeed=" + this.getMaxSpeed() + ", steeringDirection=" + this.getSteeringDirection()
				+ ", energyLevel=" + this.getEnergyLevel() + ", damageLevel=" + this.getDamageLevel() + "\n";
		return parentOutput + output;
	}

}
