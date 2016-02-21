package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Distance;
import org.usfirst.frc.team1160.robot.commands.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.air.ShootPosition;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireSequence extends CommandGroup implements RobotMap{

	public FireSequence(){
		System.out.println("thing going i think");
		//addSequential(new ShootPosition());
		//addParallel(new SpinWheels());
		System.out.println("spin wheels has been called");
		//addParallel(new ReadyAimFire());
		System.out.println("past readyaim");
		//addSequential(new StopWheels());
		//addSequential(new CradleHold());
		//addSequential(new PickupPosition());
		
	}
}
