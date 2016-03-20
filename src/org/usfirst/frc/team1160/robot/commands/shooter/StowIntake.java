package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StowIntake extends CommandGroup {
	
	public StowIntake(){
		addSequential(new SpinWheels(0, 100));		
		addSequential(new CradleHold());
	}
}
