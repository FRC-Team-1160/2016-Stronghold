package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	public static Shooter instance;
	
	Talon big, small;
	
	public static Shooter getInstance(){
		if(instance == null){
			instance = new Shooter();
		}
		return instance;
	}
	
	public Shooter(){
		big = new Talon(RobotMap.S_FLYWHEEL_LARGE);
		small = new Talon(RobotMap.S_FLYWHEEL_SMALL);
		  
	}
	
	public void setFlywheel(double speed){
		big.set(speed);
		small.set(speed);
	}
	protected void initDefaultCommand() {
		
	}

}
