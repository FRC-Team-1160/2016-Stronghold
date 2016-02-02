package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem{


	public static Vision instance;
	
	
	public static Vision getInstance(){
		if (instance == null){
			instance = new Vision();
		}
		return instance;
	}
	
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
