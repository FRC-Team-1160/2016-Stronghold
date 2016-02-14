package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.air.ShootPosition;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireSequence extends CommandGroup implements RobotMap{

	public FireSequence(double speed){
		
		addSequential(new ShootPosition());
		addParallel(new SpinWheels(Robot.shoot.speedFromDistance(Robot.see.getDistanceToTarget(0))),FIRING_TIME+.2);
		addParallel(new ReadyAimFire());
		addSequential(new StopWheels());
		addSequential(new CradleHold());
		//addSequential(new PickupPosition());
		
	}
}
