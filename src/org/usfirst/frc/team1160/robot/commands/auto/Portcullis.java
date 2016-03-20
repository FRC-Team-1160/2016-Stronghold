package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDistance;
import org.usfirst.frc.team1160.robot.commands.shooter.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.shooter.air.ShootPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Portcullis extends CommandGroup implements RobotMap{
	
	public Portcullis(){
		
		addSequential(new PickupPosition());
		addSequential(new DriveDistance(PORTCULLIS_DISTANCE));
		addSequential(new ShootPosition());
		
	}
	
}