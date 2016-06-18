package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.shooter.Intake;
import org.usfirst.frc.team1160.robot.commands.shooter.LowGoal;
import org.usfirst.frc.team1160.robot.commands.shooter.ShootSequence;
import org.usfirst.frc.team1160.robot.commands.shooter.Spitter;
import org.usfirst.frc.team1160.robot.commands.shooter.StopWheel;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleShoot;
import org.usfirst.frc.team1160.robot.commands.shooter.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.shooter.air.ShootPosition;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI implements RobotMap{
    
	public static OI instance;
	Joystick autoInput, fireTest;
	ModifiedJoystick stick;
	JoystickButton intake, cradleUp, cradleDown, shoot, armDown, armUp, stop, spit, lowGoal;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
			}
		return instance;
		}
	
	private OI(){
		stick = new ModifiedJoystick(1);
		autoInput = new Joystick(0);
	}
	
	public void buttons(){
		intake = new JoystickButton(stick, 3);
		cradleDown = new JoystickButton(stick, 4);
		cradleUp = new JoystickButton(stick, 5);
		stop = new JoystickButton(stick, 6);
		armDown = new JoystickButton(stick, 7);
		armUp = new JoystickButton(stick, 8);
		shoot = new JoystickButton(stick, 9);
		spit = new JoystickButton(stick, 2);
		lowGoal = new JoystickButton(stick, 1);
		tieButtons();
	}
	
	public void tieButtons(){
		intake.whenPressed(new Intake());
		cradleDown.whenPressed(new CradleHold());
		cradleUp.whenPressed(new CradleShoot());
		stop.whenPressed(new StopWheel());
		armDown.whenPressed(new PickupPosition());
		armUp.whenPressed(new ShootPosition());
		shoot.whenPressed(new ShootSequence());
		spit.whenPressed(new Spitter());
		lowGoal.whenPressed(new LowGoal());
		
	}
	
	public ModifiedJoystick getStick(){
		return stick;
	}
	
	public Joystick getAutoInput(){
		return autoInput;
	}
	
	public Joystick getTest(){
		return fireTest;
	}
	
	public boolean getFireMode(){
		return autoInput.getRawButton(12);
	}
	
}