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
	
	public OI(){

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