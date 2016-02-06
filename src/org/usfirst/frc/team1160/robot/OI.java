package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.Detect;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI implements RobotMap{
    
	public static OI instance;
	Joystick autoInput;
	ModifiedJoystick stick;
	JoystickButton detect;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
			}
		return instance;
		}
	
	public OI(){
		stick = new ModifiedJoystick(STICK);
		autoInput = new Joystick(AUTO_INPUT_PORT);
	}
	
	public ModifiedJoystick getStick(){
		return stick;
	}
	
	public Joystick getAutoInput(){
		return autoInput;
	}
	
	public void buttons(){
		detect = new JoystickButton(stick,SEE_BUTTON);
		
		tieButtons();
	}
	
	public void tieButtons(){
		detect.whenPressed(new Detect());
	}
}