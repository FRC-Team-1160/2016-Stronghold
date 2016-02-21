package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.air.ShootPosition;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireSequence extends CommandGroup implements RobotMap{

	public FireSequence(){
		addSequential(new ShootPosition());
		addSequential(new SpinWheels());
		addSequential(new ReadyAimFire());
		addSequential(new StopWheels());
		addSequential(new CradleHold());		
	}
}
