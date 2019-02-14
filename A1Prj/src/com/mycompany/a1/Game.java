package com.mycompany.a1;

import com.codename1.components.ToastBar;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{
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
				
				switch (sCommand.charAt(0)) {
					case 'a':
						ToastBar.showInfoMessage("GameWorld accelorate");
					break;
					case 'b':
						ToastBar.showInfoMessage("GameWorld break");
					break;
					case 'l':
						ToastBar.showInfoMessage("Steer Robot Left");
					break;
					case 'r':
						ToastBar.showInfoMessage("Steer Robot Right");
					break;
					case 'c':
						ToastBar.showInfoMessage("PRETEND Robot collided with another robot");
					break;
					case '1':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '2':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '3':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '4':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '5':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '6':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '7':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '8':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
					break;
					case '9':
						ToastBar.showInfoMessage("PRETEND Robot collided with BASE #");
						break;
					case 'e':
						ToastBar.showInfoMessage("PRETEND Robot collided with EnergyStation");
						break;
					case 'g':
						ToastBar.showInfoMessage("PRETEND Robot collided with Drone got slower");
						break;					
					case 't':
						ToastBar.showInfoMessage("Tell GameWorld to tick the clock");
						break;
					case 'd':
						ToastBar.showInfoMessage("Generate Display Lines to console");
						break;
					case 'm':
						ToastBar.showInfoMessage("Tell GameWorld to output map");
						break;
					case 'x'://Confirm the user wants to exit Game
						String sConfirm = myTextField.getText().toString();
						myTextField.clear();
						ToastBar.showInfoMessage("Are you sure you want to Exit? 'y' or 'n'");
						switch(sConfirm.charAt(0)) {
							case 'y':
								gw.exit();
								break;
							case 'n':
								default:
							}
						break;
						default:
							ToastBar.showErrorMessage("Invalid Command");
							break;
							
							//add code to handle rest of the commands
				} //switch  
			} //actionPerformed     
		});//new ActionListener()  
		//addActionListener  
	} //play 
				
	
	

}
