package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;
import com.codename1.components.ToastBar;
import com.codename1.ui.Form;
import com.codename1.ui.geom.Point2D;

/**
 * This class instantiates and uses all GameWorld objects
 * This class also extends the Form class in 
 * com.codename1.ui to display information to the users device
 * @author Shane Harris
 * @version 1.0
 *
 */
public class GameWorld extends Form{
	private ArrayList<GameObject> gameObjects;
	final private double WIDTH;
	final private double HEIGHT;
	private double originX;
	private double originY;
	private Point2D point;
	private int clock;
	private int lives;
	private Random random = new Random();
	private EnergyStation energyStation;
	private Drone drone;
	private Base base;

	/**
	 * This constructor initializes this GameWorld object
	 * With width=1024, height=768, lives=3 and a clock 
	 * counter
	 */
	public GameWorld() {
		this.WIDTH = 1024.0;
		this.HEIGHT = 768.0;
		this.originX = 0.0;
		this.originY = 0.0;
		this.lives = 3;
		this.clock = 0;
		this.point = new Point2D(originX, originY);

	}

	/**
	 * This method is called to instantiate all on the 
	 * GameWorld objects. this method is called at the 
	 * start of the game and whenever a Robot life is
	 * lost.
	 */
	public void init() {
		gameObjects = new ArrayList<GameObject>();

		gameObjects.add(Robot.getRobot());
		for (int i = 0; i < random.nextInt(5) + 1; i++) {
			drone = new Drone();
			gameObjects.add(drone);
		}

		for (int i = 0; i < random.nextInt(6) + 1; i++) {
			energyStation = new EnergyStation();
			gameObjects.add(energyStation);
		}
		base = new Base(point, 1);
		gameObjects.add(base);

		point = new Point2D(110, 131);
		base = new Base(point, 2);
		gameObjects.add(base);

		point = new Point2D(200, 191);
		base = new Base(point, 3);
		gameObjects.add(base);

		point = new Point2D(321, 331);
		base = new Base(point, 4);
		gameObjects.add(base);

		point = new Point2D(610, 631);
		base = new Base(point, 5);
		gameObjects.add(base);

	}
	
	/**
	 * This method returns the clock value
	 * @return clock value
	 */
	public int getClock(){
		return this.clock;
	}
	
	/**
	 * This method returns the number of 
	 * Robot lives left
	 * @return lives left
	 */
	public int getLives(){
		return this.lives;
	}

	/**
	 * This method itterates the clock and runs the move() method for all 
	 * GameWorld objects of type Moveable. This method also adjust heading's
	 * of the Robot and Drone objects.
	 */
	public void tick() {

		clock++;

		for (GameObject gO : gameObjects) {
			if (gO instanceof Moveable) {
				((Moveable) gO).move(); // move sets location no need to call setLocation()
			}
			if (gO instanceof Robot) {
				((Robot) gO).consumeEnergy(); // energy consumed after move
				if(((Robot) gO).getEnergyLevel() == 8) {
					System.out.println("Robot is out of energy life lost");
					lives--;
					((Robot) gO).respawn();
					init();
				}
				if(((Robot) gO).getDamageLevel() == 100) {
					System.out.println("Robot damage is 100% life lost");
					lives--;
					((Robot) gO).respawn();
					init();
				}
			}
			if (gO instanceof Drone) {
				((Drone) gO).randomHeading();// aulters Drone heading after move
			}
			
		}

	}

	/**
	 * This method displays the number of lives left
	 * the current clock value, the highest base 
	 * number the Robot has reached, energy level, 
	 * and current damage
	 */
	public void display() {
		
		String displayAll="";
		displayAll += "Lives= " + this.getLives() +" , ";
		displayAll += "Clock= " + this.getClock() +"\n";
		for(GameObject robot : gameObjects) {
			if(robot instanceof Robot) {
				displayAll += "Highest Base Reached= "+((Robot) robot).getLastBaseReached()+"\n";
				displayAll += "Robot Energy Level = "+((Robot) robot).getEnergyLevel()+"% \n";
				displayAll += "Robot Damage Level = "+((Robot) robot).getDamageLevel()+"% \n";
			}
		}
		ToastBar.setDefaultMessageTimeout(20000);
        ToastBar.showInfoMessage(displayAll);
        ToastBar.setDefaultMessageTimeout(5000);
        System.out.println(displayAll);
		
	}

	/**
	 * This method displays the stats for all the GameWorld
	 * objects in the current Game.
	 * Location, Color, Size, Sequence Number, Heading,
	 * Speed, Capacity, Steering Direction, Damage Level,
	 * Max Speed...
	 */
	public void map() {
	
		String displayAll ="";
		for(GameObject gO : gameObjects) {
			displayAll += gO.toString();
		}
        ToastBar.setDefaultMessageTimeout(20000);
        ToastBar.showInfoMessage(displayAll);
        ToastBar.setDefaultMessageTimeout(2000);
        System.out.println(displayAll);

	}

	public void update() {

	}

	/**
	 * This method is called to accelorate this Robot
	 * object. This method will only accelorate this
	 * robot in incrumemts of 5
	 */
	public void accelerate() {
	
		int accelerationAmmount = 5; // ammount can be adjusted to tweak game play
		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot) {
				((Robot) gO).accelorateRobot(accelerationAmmount);
				System.out.println("Robot speed is = "+((Robot) gO).getSpeed());
			}
		}
		
	}

	/**
	 * This method is called to decelorate this Robot
	 * object. This method will only decelorate this
	 * robot in incrumemts of -5
	 */
	public void brake() {
		
		int accelerationAmmount = -5; // ammount can be adjusted to tweak game play
		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot)
				((Robot) gO).accelorateRobot(accelerationAmmount);
		}
	}

	/**
	 * This method is called to adjust the steering direction 
	 * of this Robot object to the RIGHT. This method will only 
	 * adjust the steering direction of this robot in incrumemts
	 *  of 5
	 */
	public void steerRight() {
		
		int adjustHeadingAmmount = 5; // ammount can be adjusted to tweak game play
		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot)
				((Robot) gO).steer(adjustHeadingAmmount);
		}

	}

	/**
	 * This method is called to adjust the steering direction 
	 * of this Robot object to the LEFT. This method will only 
	 * adjust the steering direction of this robot in incrumemts
	 *  of -5
	 */
	public void steerLeft() {
	
		int adjustHeadingAmmount = -5; // ammount can be adjusted to tweak game play
		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot)
				((Robot) gO).steer(adjustHeadingAmmount);
		}
	}

	/**
	 * This method simmulates a collision between the Robot
	 * object and a Base object with indicated sequence number
	 * @param sequenceNumber the number of the indicated Base object
	 */
	public void pretendBaseCollision(int sequenceNumber) {
	
		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot) {
				if (sequenceNumber == ((Robot) gO).getLastBaseReached()+1)
					((Robot) gO).updateLastBaseReached();
			}
		}

	}

	/**
	 * his method simmulates a collision between the Robot
	 * object and a RANDOM EnergyStation object.
	 * Method Collects all EnergyStation objects then 
	 * selects one at random to collide with Robot
	 * Then this method instantiats a new EnergyStation object
	 */
	public void pretendEnergyStationCollision() {
		
		Random random = new Random();
		int pickedStation;
		final ArrayList<EnergyStation> energyStationList = new ArrayList<EnergyStation>();
		for (GameObject eS : gameObjects) {
			if (eS instanceof EnergyStation) {
				energyStationList.add((EnergyStation) eS);
			}
		}
		// Randomly selecting which station to collide Robot with
		pickedStation = random.nextInt(energyStationList.size())
				;

		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot) {
				// finding instance of robot, charging Robot to capacity of randonly selected
				// EnergyStation then reducing EnergyStations Calapity to ZERO.
				((Robot) gO).chargeRobot(energyStationList.get(pickedStation).getCapacity());
				energyStationList.get(pickedStation).transferEnergy();
			}
		}
		energyStation = new EnergyStation();
		gameObjects.add(energyStation);
	}

	/**
	 * This method simmulates a collision between the 
	 * player Robot object and a NPC Robot Object
	 * since only one Robot object is created in
	 * this version of the game just the value of
	 * the NPC robots attact is passed to this
	 * Robot object
	 */
	public void pretendRobotCollision() {
		
		int fakeRobot = 20;
		for(GameObject robot : gameObjects) {
			if(robot instanceof Robot) {
				((Robot) robot).applyDamage(fakeRobot);
			}
		}
	}

	/**
	 * This method simmulates a collision between the 
	 * player Robot object and a Random Drone object
	 */
	public void pretendDroneCollision() {
	
		Random random = new Random();
		int pickedDrone;
		final ArrayList<Drone> droneList = new ArrayList<Drone>();
		for (GameObject drone : gameObjects) {
			if (drone instanceof Drone) {
				droneList.add((Drone) drone);
			}
		}
		// Randomly selecting which Drone to collide Robot with
		pickedDrone = random.nextInt(droneList.size());

		for (GameObject gO : gameObjects) {
			if (gO instanceof Robot) {
				((Robot) gO).applyDamage(droneList.get(pickedDrone).getAttack());
			}
		}

	}

	/**
	 * This method is called to exit the Game.
	 * User must confirm exit before this method
	 * is executed
	 */
	public void exit() {
		System.exit(0);
	}

}
