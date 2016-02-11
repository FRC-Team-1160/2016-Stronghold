package org.usfirst.frc.team1160.robot.commands.Shoot.groups;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1160.robot.commands.Shoot.SpinWheels;

public class FireSequence extends CommandGroup implements RobotMap{

	Timer time;
	
	public FireSequence(double speed){
		addSequential(new SpinWheels(FIRE_BIG));
	}
	
	
}
