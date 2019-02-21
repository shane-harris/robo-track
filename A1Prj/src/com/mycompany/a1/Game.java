package com.mycompany.a1;

import com.codename1.components.ToastBar;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

/**
 * This class initializes a GameWorld object.
 * this class is a controller to the GameWorld class
 * This class extends the Form class
 * from com.codename1.ui 
 * @author Shane Harris
 * @version 1.0
 *
 */
public class Game extends Form{
	
	private GameWorld gw;
	public Game(){
		gw  = new GameWorld();
		gw.init();
		play();
		
	}
	
	/**
	 * This class creates a form on the users device 
	 * the form will contain a TextFild for the user
	 * to imput commands to controls the game
	 */
	private void play() {
		// code here to accept and
		// execute user commands that
		// operate on the game world
		//(refer to “Appendix - CN1 //Notes” for accepting
		//keyboard commands via a text //field located on the form)
		
		
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				boolean confirmQuit=false;
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() > 0) {
					switch (sCommand.charAt(0)) {
						case 'a':
							ToastBar.showInfoMessage("Accelerating Robot +5");
							System.out.println("Accelerating Robot +5");
							gw.accelerate();
							break;
						case 'b':
							ToastBar.showInfoMessage("Slowing Robot -5");
							System.out.println("Slowing Robot -5");
							gw.brake();
							break;
						case 'l':
							ToastBar.showInfoMessage("Steering Robot Left -5");
							System.out.println("Steering Robot Left -5");
							gw.steerLeft();
							break;
						case 'r':
							ToastBar.showInfoMessage("Steering Robot Right +5");
							System.out.println("Steering Robot Right +5");
							gw.steerRight();
						break;
						case 'c':
							ToastBar.showInfoMessage("PRETEND Robot collided with another robot");
							System.out.println("PRETEND Robot collided with another robot");
							gw.pretendRobotCollision();
							break;
						case '1':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #1");
							System.out.println("PRETEND Robot collided with BASE #1");
							gw.pretendBaseCollision(1);
							break;
						case '2':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #2");
							System.out.println("PRETEND Robot collided with BASE #2");
							gw.pretendBaseCollision(2);
							break;
						case '3':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #3");
							System.out.println("PRETEND Robot collided with BASE #3");
							gw.pretendBaseCollision(3);
							break;
						case '4':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #4");
							System.out.println("PRETEND Robot collided with BASE #4");
							gw.pretendBaseCollision(4);
							break;
						case '5':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #5");
							System.out.println("PRETEND Robot collided with BASE #5");
							gw.pretendBaseCollision(5);
							break;
						case '6':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #6");
							System.out.println("PRETEND Robot collided with BASE #6");
							gw.pretendBaseCollision(6);
							break;
						case '7':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #7");
							System.out.println("PRETEND Robot collided with BASE #7");
							gw.pretendBaseCollision(7);
							break;
						case '8':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #8");
							System.out.println("PRETEND Robot collided with BASE #8");
							gw.pretendBaseCollision(8);
							break;
						case '9':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #9");
							System.out.println("PRETEND Robot collided with BASE #9");
							gw.pretendBaseCollision(9);
							break;
						case 'e':
							ToastBar.showInfoMessage("PRETEND Robot collided with EnergyStation");
							System.out.println("PRETEND Robot collided with EnergyStation");
							gw.pretendEnergyStationCollision();
							break;
						case 'g':
							ToastBar.showInfoMessage("PRETEND Robot collided with Drone got slower");
							System.out.println("PRETEND Robot collided with Drone got slower");
							gw.pretendDroneCollision();
							break;					
						case 't':
							ToastBar.showInfoMessage("GameWorld clock has ticked");
							System.out.println("GameWorld clock has ticked");
							gw.tick();
							break;
						case 'd':
							gw.display();
							break;
						case 'm':
							gw.map();
							break;
						case 'x'://Confirm the user wants to exit Game
							ToastBar.showInfoMessage("Are you sure you want to Exit? Press y for YES or n for NO");
							System.out.println("Are you sure you want to Exit? Press y for YES or n for NO");
							confirmQuit = true;
							break;
						case 'y':
							if(confirmQuit)
								gw.exit();
							break;
						case 'n':
							if(confirmQuit) {
								ToastBar.showInfoMessage("Resuming Game!");
								System.out.println("Resuming Game!");
								confirmQuit = false;
							}
							break;
						default:
							ToastBar.showErrorMessage("Invalid Command");
							System.out.println("Invalid Command");
							myTextField.clear();
							break;
							
							//add code to handle rest of the commands
					}
				} //switch  
			} //actionPerformed     
		});//new ActionListener()  
		//addActionListener  
	} //play 
				
	
	

}
