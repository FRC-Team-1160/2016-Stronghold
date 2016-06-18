
package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Spitter extends CommandGroup implements RobotMap{
	public Spitter(){
		addSequential(new Spit());
		addSequential(new Wait(1));
		addSequential(new CradleShoot());
		addSequential(new Wait(.25));
		addSequential(new CradleHold());
		addSequential(new StopWheel());
		// ^ these are placeholder values ^ //
	}
}
