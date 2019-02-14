package com.mycompany.a1;

import com.codename1.components.ToastBar;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{
	private boolean confirmQuit=false;
	
	private GameWorld gw;
	public Game(){
		gw  = new GameWorld();
		gw.init();
		play();
		
	}
	
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
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() > 0) {
				switch (sCommand.charAt(0)) {
					case 'a':
						ToastBar.showInfoMessage("GameWorld accelorate");
						myTextField.clear();
					break;
					case 'b':
						ToastBar.showInfoMessage("GameWorld break");
						myTextField.clear();
					break;
					case 'l':
						ToastBar.showInfoMessage("Steer Robot Left");
						myTextField.clear();
					break;
					case 'r':
						ToastBar.showInfoMessage("Steer Robot Right");
						myTextField.clear();
					break;
					case 'c':
						ToastBar.showInfoMessage("PRETEND Robot collided with another robot");
						myTextField.clear();
					break;
					case '1':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #1");
						myTextField.clear();
					break;
					case '2':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #2");
						myTextField.clear();
					break;
					case '3':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #3");
						myTextField.clear();
					break;
					case '4':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #4");
						myTextField.clear();
					break;
					case '5':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #5");
						myTextField.clear();
					break;
					case '6':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #6");
						myTextField.clear();
					break;
					case '7':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #7");
						myTextField.clear();
					break;
					case '8':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #8");
						myTextField.clear();
					break;
					case '9':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #9");
						myTextField.clear();
						break;
					case 'e':
						ToastBar.showInfoMessage("PRETEND Robot collided with EnergyStation");
						myTextField.clear();
						break;
					case 'g':
						ToastBar.showInfoMessage("PRETEND Robot collided with Drone got slower");
						myTextField.clear();
						break;					
					case 't':
						ToastBar.showInfoMessage("Tell GameWorld to tick the clock");
						myTextField.clear();
						break;
					case 'd':
						ToastBar.showInfoMessage("Generate Display Lines to console");
						myTextField.clear();
						break;
					case 'm':
						ToastBar.showInfoMessage("Tell GameWorld to output map");
						myTextField.clear();
						break;
					case 'x'://Confirm the user wants to exit Game
						ToastBar.showInfoMessage("Are you sure you want to Exit? 'y' or 'n'");
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
