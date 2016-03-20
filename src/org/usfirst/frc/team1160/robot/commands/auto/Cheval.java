package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDistance;
import org.usfirst.frc.team1160.robot.commands.shooter.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.shooter.air.ShootPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Cheval extends CommandGroup implements RobotMap{
	
	public Cheval(){
		
		addSequential(new DriveDistance(CHEVAL_A_DISTANCE));
		addSequential(new PickupPosition());
		addSequential(new DriveDistance(CHEVAL_B_DISTANCE));
		addSequential(new ShootPosition());
		
	}

}
