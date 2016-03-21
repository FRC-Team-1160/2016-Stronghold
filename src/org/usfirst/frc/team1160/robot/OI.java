package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.Joystick;


public class OI implements RobotMap{
    
	public static OI instance;
	Joystick autoInput, fireTest;
	ModifiedJoystick stick;
	
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

	}
	
	public void tieButtons(){

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
	
}