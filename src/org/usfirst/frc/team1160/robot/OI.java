package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.Distance;
import org.usfirst.frc.team1160.robot.commands.Shoot.FireSequence;
import org.usfirst.frc.team1160.robot.commands.Shoot.Intake;
import org.usfirst.frc.team1160.robot.commands.Shoot.SpinWheels;
import org.usfirst.frc.team1160.robot.commands.Shoot.StopWheels;
import org.usfirst.frc.team1160.robot.commands.Shoot.TestFire;
import org.usfirst.frc.team1160.robot.commands.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.air.ShootPosition;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI implements RobotMap{
    
	public static OI instance;
	Joystick autoInput, fireTest;
	ModifiedJoystick stick;
	JoystickButton detect, fire, stop, intake, up, down, test, see;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
			}
		return instance;
		}
	
	public OI(){
		stick = new ModifiedJoystick(STICK);
		fireTest = new Joystick(TEST_STICK);
		autoInput = new Joystick(AUTO_INPUT_PORT);
		
		buttons();
	}
	
	public void buttons(){
		detect = new JoystickButton(stick,SEE_BUTTON);
		fire = new JoystickButton(stick, FIRE);
		stop = new JoystickButton(stick, STOP);
		intake = new JoystickButton(stick, INTAKE);
		up = new JoystickButton(stick, PIVOT_UP);
		down = new JoystickButton(stick, PIVOT_DOWN);
		test = new JoystickButton(stick, TEST);
		see = new JoystickButton(stick,SEE);
		
		tieButtons();
	}
	
	public void tieButtons(){
		//detect.whenPressed(new Detect());
		fire.whenPressed(new SpinWheels());
		stop.whenPressed(new StopWheels());
		intake.whenPressed(new Intake(INTAKE_SPEED));
		up.whenPressed(new ShootPosition());
		down.whenPressed(new PickupPosition());
		test.whenPressed(new FireSequence());
		see.whenPressed(new Distance(0));
		System.out.println("WOY");
	}
	
	public ModifiedJoystick getStick(){
		return stick;
	}
	
	public Joystick getAutoInput(){
		return autoInput;
	}
	
	public Joystick getTest(){
//		System.out.println("PLS WORK");
		return fireTest;
	}
	
}