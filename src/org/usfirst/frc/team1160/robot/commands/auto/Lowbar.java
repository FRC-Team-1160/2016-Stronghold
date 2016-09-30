package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDistance;
import org.usfirst.frc.team1160.robot.commands.shooter.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.shooter.air.ShootPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Lowbar extends CommandGroup implements RobotMap{
	
	public Lowbar(){
		addSequential(new PickupPosition());
		addSequential(new Wait(4));
		//addSequential(new DriveDistance(-.5));
		addSequential(new UnevenTerrain());
		addSequential(new ShootPosition());
	}
	
}
