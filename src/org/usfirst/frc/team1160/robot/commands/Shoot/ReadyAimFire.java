package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.air.CradlePush;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReadyAimFire extends CommandGroup implements RobotMap{

	public ReadyAimFire(){
		addSequential(new Wait(FIRING_TIME));
		addSequential(new CradlePush());
	}
}
