package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class UnevenTerrain extends CommandGroup implements RobotMap{
	
	public UnevenTerrain(){
		
		//addSequential(new DriveDistance(-.5));
		addSequential(new DriveDistance(ROUGH_DISTANCE));
		
	}
	
}
