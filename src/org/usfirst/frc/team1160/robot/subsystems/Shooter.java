package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	public static Shooter instance;
	
	public static Shooter getInstance(){
		if(instance == null){
			instance = new Shooter();
		}
		return instance;
	}
	
	public Shooter(){
		
	}
	
	protected void initDefaultCommand() {
		
	}

}
