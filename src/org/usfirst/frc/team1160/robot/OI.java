package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.Detect;

import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
    
	public static OI instance;
	ModifiedJoystick stick;
	JoystickButton detect;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
			}
		return instance;
		}
	
	public OI(){
		stick = new ModifiedJoystick(RobotMap.STICK);
	}
	
	public ModifiedJoystick getStick(){
		return stick;
	}
	
	public void buttons(){
		detect = new JoystickButton(stick,RobotMap.SEE_BUTTON);
		
		tieButtons();
	}
	
	public void tieButtons(){
		detect.whenPressed(new Detect());
	}
}