package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.Detect;
import org.usfirst.frc.team1160.robot.commands.Shoot.Intake;
import org.usfirst.frc.team1160.robot.commands.Shoot.SpinWheels;
import org.usfirst.frc.team1160.robot.commands.Shoot.StopWheels;
import org.usfirst.frc.team1160.robot.commands.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.air.ShootPosition;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI implements RobotMap{
    
	public static OI instance;
	Joystick autoInput;
	ModifiedJoystick stick;
	JoystickButton detect, fire, stop, intake, up, down;
	
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
	
	public void buttons(){
		detect = new JoystickButton(stick,SEE_BUTTON);
		fire = new JoystickButton(stick, FIRE);
		stop = new JoystickButton(stick, STOP);
		intake = new JoystickButton(stick, INTAKE);
		up = new JoystickButton(stick, PIVOT_UP);
		down = new JoystickButton(stick, PIVOT_DOWN);
		
		tieButtons();
	}
	
	public void tieButtons(){
		detect.whenPressed(new Detect());
		fire.whenPressed(new SpinWheels(1));
		stop.whenPressed(new StopWheels());
		intake.whenPressed(new Intake(INTAKE_SPEED));
		up.whenPressed(new ShootPosition());
		down.whenPressed(new PickupPosition());
	}
	
	public ModifiedJoystick getStick(){
		return stick;
	}
	
	public Joystick getAutoInput(){
		return autoInput;
	}
	
}