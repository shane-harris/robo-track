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
							ToastBar.showInfoMessage("Accelerating Robot");
							gw.accelerate();
							break;
						case 'b':
							ToastBar.showInfoMessage("Slowing Robot");
							gw.brake();
							break;
						case 'l':
							ToastBar.showInfoMessage("Steering Robot Left");
							gw.steerLeft();
							break;
						case 'r':
							ToastBar.showInfoMessage("Steering Robot Right");
							gw.steerRight();
						break;
						case 'c':
							ToastBar.showInfoMessage("PRETEND Robot collided with another robot");
							gw.pretendRobotCollision();
							break;
						case '1':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #1");
							gw.pretendBaseCollision(1);
							break;
						case '2':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #2");
							gw.pretendBaseCollision(2);
							break;
						case '3':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #3");
							gw.pretendBaseCollision(3);
							break;
						case '4':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #4");
							gw.pretendBaseCollision(4);
							break;
						case '5':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #5");
							gw.pretendBaseCollision(sCommand.charAt(0) -'0');
							break;
						case '6':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #6");
							gw.pretendBaseCollision(sCommand.charAt(0) -'0');
							break;
						case '7':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #7");
							gw.pretendBaseCollision(sCommand.charAt(0) -'0');
							break;
						case '8':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #8");
							gw.pretendBaseCollision(sCommand.charAt(0) -'0');
							break;
						case '9':
							ToastBar.showInfoMessage("PRETEND Robot collided with BASE #9");
							gw.pretendBaseCollision(sCommand.charAt(0) -'0');
							break;
						case 'e':
							ToastBar.showInfoMessage("PRETEND Robot collided with EnergyStation");
							gw.pretendEnergyStationCollision();
							break;
						case 'g':
							ToastBar.showInfoMessage("PRETEND Robot collided with Drone got slower");
							gw.pretendDroneCollision();
							break;					
						case 't':
							ToastBar.showInfoMessage("Tell GameWorld to tick the clock");
							gw.tick();
							break;
						case 'd':
							//ToastBar.showInfoMessage("Generate Display Lines to console");
							gw.display();
							break;
						case 'm':
							//ToastBar.showInfoMessage("Tell GameWorld to output map");
							gw.map();
							break;
						case 'x'://Confirm the user wants to exit Game
							ToastBar.showInfoMessage("Are you sure you want to Exit? Press y for YES or n for NO");
							confirmQuit = true;
							break;
						case 'y':
							if(confirmQuit)
								gw.exit();
							break;
						case 'n':
							if(confirmQuit) {
								ToastBar.showInfoMessage("Resuming Game!");
								confirmQuit = false;
							}
							break;
						default:
							ToastBar.showErrorMessage("Invalid Command");
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
