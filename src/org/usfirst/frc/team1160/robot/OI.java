package org.usfirst.frc.team1160.robot;


public class OI {
    
	public static OI instance;
	ModifiedJoystick stick;
	
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
}